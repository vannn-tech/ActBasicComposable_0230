package com.example.actbasiccomposable_0230

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actbasiccomposable_0230.ui.theme.ActBasicComposable_0230Theme
import com.example.actbasiccomposable_0230.ui.theme.BluePrimary
import com.example.actbasiccomposable_0230.ui.theme.DarkText
import com.example.actbasiccomposable_0230.ui.theme.RedAccent
import com.example.actbasiccomposable_0230.ui.theme.SoftBackground

/**
 * Layar utama tugas login yang menampilkan background, logo,
 * informasi user, form input username/password, serta foto profil.
 */
@Composable
fun TugasLoginScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

            Spacer(modifier = Modifier.height(24.dp))

            LogoSection()

            Spacer(modifier = Modifier.height(24.dp))

            UserInfoSection()

            Spacer(modifier = Modifier.height(16.dp))

            LoginInputSection(
                username = username,
                onUsernameChange = { username = it },
                password = password,
                onPasswordChange = { password = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            LoginButtonSection(
                onLoginClick = {
                    val message = if (username.isNotBlank()) "Selamat datang, $username!" else "Silakan isi username terlebih dahulu"
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            )

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

/**
 * Komponen latar belakang gambar penuh.
 */
@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.background_hp),
        contentDescription = stringResource(id = R.string.bg_description),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

/**
 * Komponen judul dan sub-judul halaman login.
 */
@Composable
fun HeaderSection() {
    Text(
        text = stringResource(id = R.string.login_title),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = BluePrimary
    )
    Text(
        text = stringResource(id = R.string.login_subtitle),
        fontSize = 13.sp,
        color = Color.White
    )
}

/**
 * Komponen penampil logo UMY.
 */
@Composable
fun LogoSection() {
    Image(
        painter = painterResource(id = R.drawable.logo_umy),
        contentDescription = stringResource(id = R.string.logo_description),
        modifier = Modifier.size(120.dp),
        contentScale = ContentScale.Fit
    )
}

/**
 * Komponen kartu informasi identitas user (nama dan NIM).
 */
@Composable
fun UserInfoSection() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.85f)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.user_name_label),
                fontSize = 14.sp,
                color = RedAccent
            )
            Text(
                text = stringResource(id = R.string.user_name),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = BluePrimary
            )
            Text(
                text = stringResource(id = R.string.user_nim),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )
        }
    }
}

/**
 * Komponen foto profil masjid berbentuk lingkaran.
 */
@Composable
fun ProfileImageSection() {
    Box(
        modifier = Modifier
            .size(290.dp)
            .clip(CircleShape)
            .background(SoftBackground)
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

/**
 * Komponen input form username dan password.
 */
@Composable
fun LoginInputSection(
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChange,
            label = { Text(text = stringResource(id = R.string.username_label)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text(text = stringResource(id = R.string.password_label)) },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * Komponen tombol aksi login.
 */
@Composable
fun LoginButtonSection(
    onLoginClick: () -> Unit
) {
    Button(
        onClick = onLoginClick,
        colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login_button),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
