package pe.edu.upeu.navegationjpc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

public val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

public val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

public val sGreenlightScheme = lightColorScheme(
    primary = green_primaryLight,
    onPrimary = green_onPrimaryLight,
    primaryContainer = green_primaryContainerLight,
    onPrimaryContainer = green_onPrimaryContainerLight,
    secondary = green_secondaryLight,
    onSecondary = green_onSecondaryLight,
    secondaryContainer = green_secondaryContainerLight,
    onSecondaryContainer = green_onSecondaryContainerLight,
    tertiary = green_tertiaryLight,
    onTertiary = green_onTertiaryLight,
    tertiaryContainer = green_tertiaryContainerLight,
    onTertiaryContainer = green_onTertiaryContainerLight,
    error = green_errorLight,
    onError = green_onErrorLight,
    errorContainer = green_errorContainerLight,
    onErrorContainer = green_onErrorContainerLight,
    background = green_backgroundLight,
    onBackground = green_onBackgroundLight,
    surface = green_surfaceLight,
    onSurface = green_onSurfaceLight,
    surfaceVariant = green_surfaceVariantLight,
    onSurfaceVariant = green_onSurfaceVariantLight,
    outline = green_outlineLight,
    outlineVariant = green_outlineVariantLight,
    scrim = green_scrimLight,
    inverseSurface = green_inverseSurfaceLight,
    inverseOnSurface = green_inverseOnSurfaceLight,
    inversePrimary = green_inversePrimaryLight,
    surfaceDim = green_surfaceDimLight,
    surfaceBright = green_surfaceBrightLight,
    surfaceContainerLowest = green_surfaceContainerLowestLight,
    surfaceContainerLow = green_surfaceContainerLowLight,
    surfaceContainer = green_surfaceContainerLight,
    surfaceContainerHigh = green_surfaceContainerHighLight,
    surfaceContainerHighest = green_surfaceContainerHighestLight,
)

public val sGreendarkScheme = darkColorScheme(
    primary = green_primaryDark,
    onPrimary = green_onPrimaryDark,
    primaryContainer = green_primaryContainerDark,
    onPrimaryContainer = green_onPrimaryContainerDark,
    secondary = green_secondaryDark,
    onSecondary = green_onSecondaryDark,
    secondaryContainer = green_secondaryContainerDark,
    onSecondaryContainer = green_onSecondaryContainerDark,
    tertiary = green_tertiaryDark,
    onTertiary = green_onTertiaryDark,
    tertiaryContainer = green_tertiaryContainerDark,
    onTertiaryContainer = green_onTertiaryContainerDark,
    error = green_errorDark,
    onError = green_onErrorDark,
    errorContainer = green_errorContainerDark,
    onErrorContainer = green_onErrorContainerDark,
    background = green_backgroundDark,
    onBackground = green_onBackgroundDark,
    surface = green_surfaceDark,
    onSurface = green_onSurfaceDark,
    surfaceVariant = green_surfaceVariantDark,
    onSurfaceVariant = green_onSurfaceVariantDark,
    outline = green_outlineDark,
    outlineVariant = green_outlineVariantDark,
    scrim = green_scrimDark,
    inverseSurface = green_inverseSurfaceDark,
    inverseOnSurface = green_inverseOnSurfaceDark,
    inversePrimary = green_inversePrimaryDark,
    surfaceDim = green_surfaceDimDark,
    surfaceBright = green_surfaceBrightDark,
    surfaceContainerLowest = green_surfaceContainerLowestDark,
    surfaceContainerLow = green_surfaceContainerLowDark,
    surfaceContainer = green_surfaceContainerDark,
    surfaceContainerHigh = green_surfaceContainerHighDark,
    surfaceContainerHighest = green_surfaceContainerHighestDark,
)

enum class ThemeType{RED, GREEN}
@Composable
fun NavegationJPCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    colorScheme: ColorScheme, //Agregado
    content: @Composable () -> Unit
) {
   /*
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    } */

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}