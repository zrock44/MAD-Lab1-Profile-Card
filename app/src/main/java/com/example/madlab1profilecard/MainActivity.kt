package com.example.madlab1profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madlab1profilecard.ui.theme.MADLab1ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MADLab1ProfileCardTheme {
                Surface {
                    ProfileCard()
                }
            }
        }
    }
}

// Composable that combines the profile image and text.
@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            ProfileImage()
            ProfileText()
        }
    }
}

// All text for the profile card.
@Composable
fun ProfileText(modifier: Modifier = Modifier) {
    Column {
        // Top text. Contains my name.
        Text(
            text = stringResource(R.string.profile_name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        // Bottom text. Contains my bio.
        Text(
            text = stringResource(R.string.profile_bio),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

// Image for the user profile. In this case it's my cat Biggie.
@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    val profileImage = painterResource(R.drawable.profile_image)
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            contentDescription = stringResource(R.string.profile_image_description),
            painter = profileImage,
            modifier = Modifier
                .clip(CircleShape)
                .align(Alignment.Center)
        )
    }
}

// Preview.
@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    MADLab1ProfileCardTheme {
        Surface {
            ProfileCard()
        }
    }
}