package pe.edu.upeu.navegationjpc.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun CalcScreen() {
    var textState by remember { mutableStateOf("0") }
    var isNewOp by remember { mutableStateOf(true) }
    var oldTextState by remember { mutableStateOf("") }
    var op by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display current value
        calcScreen(value = textState)

        // Calculator button grid
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Scientific calculator buttons
            val buttons = listOf(
                listOf("AC", "^", "√", "%"),
                listOf("7", "8", "9", "/"),
                listOf("4", "5", "6", "*"),
                listOf("1", "2", "3", "-"),
                listOf("0", ".", "π", "+"),
                listOf("1/x", "=")
            )

            for (row in buttons.dropLast(1)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    row.forEach { buttonValue ->
                        Box(modifier = Modifier.weight(1f)) {
                            ButtonX(
                                modifier = Modifier.fillMaxWidth(),
                                valuex = buttonValue,
                                onValueChange = { textState = it },
                                onIsNewOpChange = { isNewOp = it },
                                textState = textState,
                                isNewOp = isNewOp,
                                onOpChange = { op = it },
                                onOldValueChange = { oldTextState = it },
                                oldTextState = oldTextState,
                                op = op
                            )
                        }
                    }
                }
            }

            // Last row with special buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                buttons.last().forEach { buttonValue ->
                    Box(modifier = Modifier.weight(1f)) {
                        ButtonX(
                            modifier = Modifier.fillMaxWidth(),
                            valuex = buttonValue,
                            onValueChange = { textState = it },
                            onIsNewOpChange = { isNewOp = it },
                            textState = textState,
                            isNewOp = isNewOp,
                            onOpChange = { op = it },
                            onOldValueChange = { oldTextState = it },
                            oldTextState = oldTextState,
                            op = op
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun calcScreen(value: String) {
    Text(
        text = value,
        style = TextStyle(fontSize = 36.sp, color = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF00BCD4))
            .padding(16.dp)
    )
}

@Composable
fun ButtonX(
    modifier: Modifier,
    valuex: String,
    onValueChange: (String) -> Unit,
    onIsNewOpChange: (Boolean) -> Unit,
    textState: String,
    isNewOp: Boolean,
    onOpChange: (String) -> Unit,
    onOldValueChange: (String) -> Unit,
    oldTextState: String,
    op: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(60.dp)
            .background(Color(0xFF00BCD4))
            .border(width = 0.5.dp, Color(0xFF2C2F32))
            .clickable(
                enabled = true,
                onClick = {
                    // Handle numeric input
                    if (isNumeric(valuex)) {
                        var valor = textState
                        if (isNewOp) {
                            valor = ""
                            onValueChange(valor)
                        }
                        onIsNewOpChange(false)
                        valor += valuex
                        onValueChange(valor)
                    }
                    // Handle operators
                    if (valuex in listOf("+", "-", "*", "/", "%")) {
                        onOpChange(valuex)
                        onOldValueChange(textState)
                        onIsNewOpChange(true)
                    }
                    // Handle clear
                    if (valuex == "AC") {
                        onValueChange("0")
                        onIsNewOpChange(true)
                    }
                    // Handle decimal point
                    if (valuex == ".") {
                        var dot = textState
                        if (isNewOp) {
                            dot = ""
                            onValueChange(dot)
                        }
                        onIsNewOpChange(false)
                        if (!dot.contains(".")) {
                            dot += "."
                            onValueChange(dot)
                        }
                    }
                    // Handle scientific operations
                    when (valuex) {
                        "^" -> {
                            onOpChange(valuex)
                            onOldValueChange(textState)
                            onIsNewOpChange(true)
                        }
                        "√" -> {
                            val result = calculateSquareRoot(textState.toDoubleOrNull() ?: 0.0)
                            onValueChange(result.toString())
                            onIsNewOpChange(true)
                        }
                        "1/x" -> {
                            val result = calculateReciprocal(textState.toDoubleOrNull() ?: 0.0)
                            onValueChange(result.toString())
                            onIsNewOpChange(true)
                        }
                        "π" -> {
                            onValueChange(PI.toString())
                            onIsNewOpChange(true)
                        }
                        "=" -> {
                            if (oldTextState.isNotEmpty() && textState.isNotEmpty()) {
                                val result = when (op) {
                                    "+" -> (oldTextState.toDoubleOrNull() ?: 0.0) + (textState.toDoubleOrNull() ?: 0.0)
                                    "-" -> (oldTextState.toDoubleOrNull() ?: 0.0) - (textState.toDoubleOrNull() ?: 0.0)
                                    "*" -> (oldTextState.toDoubleOrNull() ?: 0.0) * (textState.toDoubleOrNull() ?: 0.0)
                                    "/" -> (oldTextState.toDoubleOrNull() ?: 0.0) / (textState.toDoubleOrNull() ?: 0.0)
                                    "%" -> (oldTextState.toDoubleOrNull() ?: 0.0) % (textState.toDoubleOrNull() ?: 0.0)
                                    "^" -> calculatePower(oldTextState.toDoubleOrNull() ?: 0.0, textState.toDoubleOrNull() ?: 0.0)
                                    else -> textState.toDoubleOrNull() ?: 0.0
                                }
                                onValueChange(result.toString())
                                onIsNewOpChange(true)
                            }
                        }
                    }
                }
            )
    ) {
        Text(
            text = valuex,
            fontSize = 24.sp,
            color = Color.White
        )
    }
}

// Helper functions
fun isNumeric(value: String): Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return value.matches(regex)
}

fun calculatePower(base: Double, exponent: Double): Double {
    return base.pow(exponent)
}

fun calculateSquareRoot(value: Double): Double {
    return sqrt(value)
}

fun calculateReciprocal(value: Double): Double {
    return if (value != 0.0) 1 / value else Double.NaN
}