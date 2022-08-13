package co.daneshyarwithmahdikhorshidi.medicationschool.utils.customInputLayout

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomInputLayout(
    text: MutableState<String>,
    onValueChanged: (String) -> Unit = {},
) {
    val context = LocalContext.current
    val localKeyBoard = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        enabled = true,
        readOnly = false,
        label = {
            Text(text = "نام دارو را وارد کنید (انگلیسی یا فارسی فرقی ندارد) چند حرف ابتدایی کافیست")
        },
        placeholder = {},
        leadingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Medication,
                    contentDescription = "Search",
                    tint = Color(0xFF10AF10)
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                if (text.value.isEmpty()) {
                    Toast.makeText(context, "دارویی وارد نشده است", Toast.LENGTH_SHORT).show()
                } else {
                    localKeyBoard?.hide()
                    onValueChanged(text.value)
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        },
        keyboardActions = KeyboardActions(onSearch = {
            if (text.value.isEmpty()) {
                return@KeyboardActions
            } else {
                localKeyBoard?.hide()
                onValueChanged(text.value)
            }

        }),
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        maxLines = 1,
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(70.dp),
    )
}