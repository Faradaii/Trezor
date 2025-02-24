package com.faradaii.trezor.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faradaii.trezor.R
import com.faradaii.trezor.core.common.utils.ResourceState
import com.faradaii.trezor.core.presentation.ui.CoinAdapter
import com.faradaii.trezor.databinding.FragmentHomeBinding
import com.faradaii.trezor.detail.DetailCoinActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val coinAdapter = CoinAdapter()
            coinAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailCoinActivity::class.java)
                intent.putExtra(DetailCoinActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.coin.observe(viewLifecycleOwner) { coin ->
                if (coin != null) {
                    when (coin) {
                        is ResourceState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is ResourceState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            coinAdapter.submitList(coin.data)
                        }

                        is ResourceState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.tvError.text =
                                coin.message ?: getString(R.string.something_went_wrong)
                        }
                    }
                }
            }

            with(binding.rvCoin.rvCoin) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = coinAdapter
            }
        }
    }
}