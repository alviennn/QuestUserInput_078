package com.example.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf(" ") }
    var email by remember { mutableStateOf(" ") }
    var alamat by remember { mutableStateOf(" ") }
    var noHP by remember { mutableStateOf(" ")  }
    var selectedGender by remember { mutableStateOf(" ") }

    val jnsKelamin = listOf("Laki-laki", "Perempuan")

    var usernama by rememberSaveable { mutableStateOf(" ") }
    var useremail by remember { mutableStateOf(" ") }
    var useralamat by remember { mutableStateOf(" ") }
    var usernoHP by remember { mutableStateOf(" ")  }
    var usergender by remember { mutableStateOf(" ") }

    Column (Modifier.fillMaxSize().padding(16.dp)
    , horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama")
            }, label = {Text("Nama")},
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row (){
            jnsKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email")
            }, label = {Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat")
            }, label = {Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan No Telepon")
            }, label = {Text("No Telepon")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = {
            usernama = nama
            usergender = selectedGender
            useremail = email
            useralamat = alamat
            usernoHP = noHP
        }) {
            Text("Simpan")
        }

        Card (modifier.size(height = 230.dp, width = 400.dp)){
            CardSection(Judul = "Nama", IsiJudul = usernama)
            CardSection(Judul = "Jenis Kelamin", IsiJudul = usergender)
            CardSection(Judul = "Email", IsiJudul = useremail)
            CardSection(Judul = "Alamat", IsiJudul = useralamat)
            CardSection(Judul = "No Telepon", IsiJudul = usernoHP)
        }
    }
}

@Composable
fun CardSection(Judul:String, IsiJudul:String){
    Column (horizontalAlignment = Alignment.Start){

        Spacer(modifier = Modifier.padding(5.dp))
        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = Judul, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = IsiJudul,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
