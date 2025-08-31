package com.example.shaadidemoapp.uiComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shaadidemoapp.utils.CommonDescriptionString
import org.w3c.dom.Text

@Composable
fun SelectionButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonSize: Dp = 70.dp,
    iconSize: Dp = 36.dp,
    icon: ImageVector = Icons.Filled.Check,
    selectedTintColor: Color = Color.Red,
    nonSelectedTintColor: Color = Color.White,
    containerColor: Color = MaterialTheme.colorScheme.primary
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = CircleShape,
        modifier = modifier.size(buttonSize)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = CommonDescriptionString.SELECTION_BUTTON,
            tint = if (isSelected) selectedTintColor else nonSelectedTintColor,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Composable
fun HeadingText(
    inputText: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 22.sp,
    fontWeight: FontWeight = FontWeight.Bold,
    textColor: Color = Color.Black
) {
    Text(
        text = inputText,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textColor
    )
}

@Composable
fun SubHeadingText(
    inputText: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    textColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    Text(
        text = inputText,
        modifier = modifier,
        fontSize = fontSize,
        color = textColor
    )
}

@Composable
fun ProfilePicture(
    imageUrl: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    size: Dp = 240.dp,
    placeholderColor: Color = Color.LightGray,
    contentScale: ContentScale = ContentScale.Crop,
    shape: Shape = CircleShape,
    showLoadingIndicator: Boolean = true
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(shape)
            .background(placeholderColor),
        contentAlignment = Alignment.Center
    ) {

    }
}