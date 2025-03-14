package com.faradaii.trezor.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faradaii.trezor.core.presentation.ui.CoinAdapter
import com.faradaii.trezor.detail.DetailCoinActivity
import com.faradaii.trezor.favorite.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
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

            favoriteViewModel.favoriteCoin.observe(viewLifecycleOwner) { dataCoin ->
                coinAdapter.submitList(dataCoin)
                binding.tvEmpty.visibility =
                    if (dataCoin.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvCoin.rvCoin) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = coinAdapter
            }
        }
    }
}