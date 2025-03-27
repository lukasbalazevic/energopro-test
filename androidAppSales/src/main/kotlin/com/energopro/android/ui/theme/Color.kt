package com.energopro.android.ui.theme


import androidx.compose.ui.graphics.Color

data class Colors(
    // Background
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val backgroundTertiaryGreen: Color,

    // Brand
    val brandOrange: Color,
    val brandOrangeLight: Color,
    val brandPrimary: Color,
    val textPrimary: Color,
    val textPrimaryWhite: Color,
    val textSecondary: Color,
    val textSecondaryWhite: Color,
    val textTertiaryWhite: Color,

    // Status
    val statusDisabled: Color,
    val statusNegative: Color,

    // Text
    val textTertiary: Color,

    // Border
    val borderBlack: Color,
    val borderGray: Color,

    // Button
    val buttonDisabled: Color,
)

fun customColors() = Colors(
    backgroundPrimary = Color(color = 0xFFF4F7F8),
    backgroundSecondary = Color(color = 0xFFFFFFFF),
    backgroundTertiary = Color(0xFFEFEFEF),
    backgroundTertiaryGreen = Color(0xFFE9ECED),

    brandOrange = Color(color = 0xFFF77D3B),
    brandOrangeLight = Color(color = 0xFFFDE5D8),
    brandPrimary = Color(color = 0xFF196C76),

    statusDisabled = Color(color = 0x4D000000),
    statusNegative = Color(color = 0xFFC72222),

    textPrimary = Color(color = 0xFF051B1D),
    textPrimaryWhite = Color(color = 0xFFFFFFFF),
    textSecondary = Color(color = 0xB3051B1D),
    textSecondaryWhite = Color(0xB3FFFFFF),
    textTertiary = Color(0x80101F1F),
    textTertiaryWhite = Color(color = 0xFFFEFFFF),

    borderBlack = Color(color = 0x251F1C1A),
    borderGray = Color(color = 0xFFF1F1F1),
    buttonDisabled = Color(color = 0x4D000000),
)
