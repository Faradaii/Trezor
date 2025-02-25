# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn java.lang.invoke.StringConcatFactory

-keep class com.faradaii.trezor.core.databinding.** { *; }
-keepclassmembers class com.faradaii.trezor.core.databinding.** { *; }

-keep class com.faradaii.trezor.core.data.** { *; }
-keepclassmembers class com.faradaii.trezor.core.data.** { *; }
-keep class com.faradaii.trezor.core.data.local.** { *; }
-keepclassmembers class com.faradaii.trezor.core.data.local.** { *; }
-keep class com.faradaii.trezor.core.data.remote.** { *; }
-keepclassmembers class com.faradaii.trezor.core.data.remote.** { *; }

-keep class com.faradaii.trezor.core.domain.entities.** { *; }
-keepclassmembers class com.faradaii.trezor.core.domain.entities.** { *; }
-keep class com.faradaii.trezor.core.domain.repository.** { *; }
-keepclassmembers class com.faradaii.trezor.core.domain.repository.** { *; }
-keep class com.faradaii.trezor.core.domain.usecase.** { *; }
-keepclassmembers class com.faradaii.trezor.core.domain.usecase.** { *; }

-keep class com.faradaii.trezor.core.di.** { *; }
-keepclassmembers class com.faradaii.trezor.core.di.** { *; }
-keep class com.faradaii.trezor.di.** { *; }
-keepclassmembers class com.faradaii.trezor.di.** { *; }


-keep class com.faradaii.trezor.core.presentation.ui.** { *; }
-keepclassmembers class com.faradaii.trezor.core.presentation.ui.** { *; }

-keep class com.faradaii.trezor.core.common.utils.** { *; }
-keepclassmembers class com.faradaii.trezor.core.common.utils.** { *; }
-keep class com.faradaii.trezor.core.common.constant.** { *; }
-keepclassmembers class com.faradaii.trezor.core.common.constant.** { *; }
-keep class kotlin.Metadata { *; }
