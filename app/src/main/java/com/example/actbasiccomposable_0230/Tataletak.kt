package com.example.actbasiccomposable_0230

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actbasiccomposable_0230.ui.theme.ActBasicComposable_0230Theme

@Composable
fun TugasLoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BackgroundImage()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 42.dp, start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderSection()

            Spacer(modifier = Modifier.height(44.dp))

            LogoSection()

            Spacer(modifier = Modifier.height(46.dp))

            UserInfoSection()

            Spacer(modifier = Modifier.height(12.dp))

            ProfileImageSection()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TugasLoginScreenPreview() {
    ActBasicComposable_0230Theme {
        TugasLoginScreen()
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.background_hp),
        contentDescription = stringResource(id = R.string.bg_description),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeaderSection() {
    Text(
        text = stringResource(id = R.string.login_title),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
    Text(
        text = stringResource(id = R.string.login_subtitle),
        fontSize = 13.sp,
        color = Color.White
    )
}

@Composable
fun LogoSection() {
    Image(
        painter = painterResource(id = R.drawable.logo_umy),
        contentDescription = stringResource(id = R.string.logo_description),
        modifier = Modifier.size(120.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun UserInfoSection() {
    Text(
        text = stringResource(id = R.string.user_name_label),
        fontSize = 14.sp,
        color = Color.Red
    )
    Text(
        text = stringResource(id = R.string.user_name),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )
    Text(
        text = stringResource(id = R.string.user_nim),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}

@Composable
fun ProfileImageSection() {
    Box(
        modifier = Modifier
            .size(290.dp)
            .clip(CircleShape)
            .background(Color(0xFFE8E8F3))
            .border(
                width = 4.dp,
                color = Color.White,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto_masjid),
            contentDescription = stringResource(id = R.string.profile_description),
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}
