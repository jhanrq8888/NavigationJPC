package pe.edu.upeu.navegacionjpc.ui.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchThemeToggle(darktheme: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (darktheme.value) "Modo Oscuro" else "Modo Claro",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Switch(
            checked = darktheme.value,
            onCheckedChange = {
                darktheme.value = it
            }
        )
    }
}