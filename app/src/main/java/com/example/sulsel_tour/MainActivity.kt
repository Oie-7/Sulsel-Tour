package com.example.sulsel_tour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sulsel_tour.ui.theme.Sulsel_TourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sulsel_TourTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Register(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun FilledButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF22bfb5)
        ),
        modifier = modifier
    ) {
        Text(
            text = "Submit",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun OutlineButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(
            text = "Cancel",
            fontSize = 16.sp
        )
    }
}

//@Composable
//fun SplashScreen(modifier: Modifier = Modifier) {
//    Box(
//        modifier = modifier
//            .fillMaxSize(),
//        Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.sulsel_tour),
//            contentDescription = null
//        )
//    }
//}

@Composable
fun EditTextField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun Register(modifier: Modifier) {
    var nameInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logo3),
            contentDescription = "logo",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Let's Get Started",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Create your account and find more beautiful destination",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 50.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Name",
                modifier = Modifier.padding(bottom = 12.dp)
            )
//            TextField(
//                value = nameInput, onValueChange = { nameInput = it }
//            )
            EditTextField(
                label = R.string.name,
                value = nameInput,
                onValueChange = { nameInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            EditTextField(
                label = R.string.email,
                value = emailInput,
                onValueChange = { emailInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Password",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            OutlinedTextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                singleLine = true,
                placeholder = { Text(stringResource(R.string.password)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description)
                    }
                }, modifier = modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(300.dp)
                .height(40.dp)) {
            Text(
                text = "Sign up"
            )
        }
    }
}

@Composable
fun Login(modifier: Modifier) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var centang by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logo3),
            contentDescription = "logo",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome Back!",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Stay signed in with your account to make searching easier",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 50.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Column(modifier.padding(horizontal = 30.dp)) {
            Text(
                text = "Email",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            EditTextField(
                label = R.string.email,
                value = emailInput,
                onValueChange = { emailInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Password",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            OutlinedTextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                singleLine = true,
                placeholder = { Text(stringResource(R.string.password)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = {passwordVisible = !passwordVisible}){
                        Icon(imageVector  = image, description)
                    }
                }, modifier = modifier.fillMaxWidth()
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(start = 16.dp)) {
            Checkbox(
                checked = centang,
                onCheckedChange = {centang = it}
            )
            Text(
                text = "Keep me signed in",
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(300.dp)
                .height(40.dp)) {
            Text(
                text = "Sign in"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sulsel_TourTheme {
        Register(modifier = Modifier)
    }
}