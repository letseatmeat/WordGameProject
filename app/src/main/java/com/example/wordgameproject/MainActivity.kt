// Koda autors: Kirils Aleksejevs, 6. grupa, 221RDB139, 2.kurss
// Šis kods bija izveidots ar video tutoriāla palīdzību (https://www.geeksforgeeks.org/videos/how-to-build-wordle-application-in-android/)

package com.example.wordgameproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.wordgameproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Vēlākā saite uz aktivitātes izskatu, ko ielādēs ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    // Mainīgais, kurā tiks glabāts lietotāja vārds
    private var userName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ielādē aktivitātes izskatu, izmantojot saistīto klasi
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Paslēpj aktivitātes darbījvirsmu
        supportActionBar?.hide()

        // Uzsāk fokusa maiņas procesu
        focusPassingProcess()

        // Parāda dialoga logu ar vārda ievades lauku
        showNameInputDialog()

        // Pievieno teksta maiņas klausītāju pie pirmās ievades rindas, lai validētu rindu
        binding.edt15.addTextChangedListener {
            validateRow(
                binding.edt11,
                binding.edt12,
                binding.edt13,
                binding.edt14,
                binding.edt15
            )
        }

        // Pievieno teksta maiņas klausītāju pie otrās ievades rindas, lai validētu rindu
        binding.edt25.addTextChangedListener {
            validateRow(
                binding.edt21,
                binding.edt22,
                binding.edt23,
                binding.edt24,
                binding.edt25
            )
        }

        // Pievieno teksta maiņas klausītāju pie trešās ievades rindas, lai validētu rindu
        binding.edt35.addTextChangedListener {
            validateRow(
                binding.edt31,
                binding.edt32,
                binding.edt33,
                binding.edt34,
                binding.edt35
            )
        }

        // Pievieno teksta maiņas klausītāju pie ceturtās ievades rindas, lai validētu rindu
        binding.edt45.addTextChangedListener {
            validateRow(
                binding.edt41,
                binding.edt42,
                binding.edt43,
                binding.edt44,
                binding.edt45
            )
        }

        // Pievieno teksta maiņas klausītāju pie piektās ievades rindas, lai validētu rindu
        binding.edt55.addTextChangedListener {
            validateRow(
                binding.edt51,
                binding.edt52,
                binding.edt53,
                binding.edt54,
                binding.edt55
            )
        }

        // Pievieno teksta maiņas klausītāju pie sestās ievades rindas, lai validētu rindu
        binding.edt65.addTextChangedListener {
            validateRow(
                binding.edt61,
                binding.edt62,
                binding.edt63,
                binding.edt64,
                binding.edt65
            )
        }
    }
    // Funkcija, kura novertē, ko lietotajs ievada un validē katru ievades rindu spēlē
    private fun validateRow(
        edt1: EditText, edt2: EditText, edt3: EditText, edt4: EditText, edt5: EditText){

        // Iegūst tekstu no katras EditText lauka
        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()

        // Iegūst spēles vārda pirmos piecus burtu
        val word1 = WORD[0].toString()
        val word2 = WORD[1].toString()
        val word3 = WORD[2].toString()
        val word4 = WORD[3].toString()
        val word5 = WORD[4].toString()

        // Pārbauda, vai šis burts ir spēles vārdā, bet nepareizajā vietā
        if (edt1Text == word2 || edt1Text == word3 || edt1Text == word4 || edt1Text == word5) {
            edt1.setBackgroundColor(Color.parseColor("#ffff54"))
            edt1.isEnabled = false
        }
        if (edt2Text == word1 || edt2Text == word3 || edt2Text == word4 || edt2Text == word5) {
            edt2.setBackgroundColor(Color.parseColor("#ffff54"))
            edt2.isEnabled = false
        }
        if (edt3Text == word1 || edt3Text == word2 || edt3Text == word4 || edt3Text == word5) {
            edt3.setBackgroundColor(Color.parseColor("#ffff54"))
            edt3.isEnabled = false
        }
        if (edt4Text == word1 || edt4Text == word2 || edt4Text == word3 || edt4Text == word5) {
            edt4.setBackgroundColor(Color.parseColor("#ffff54"))
            edt4.isEnabled = false
        }
        if (edt5Text == word1 || edt5Text == word2 || edt5Text == word3 || edt5Text == word4) {
            edt5.setBackgroundColor(Color.parseColor("#ffff54"))
            edt5.isEnabled = false
        }

        // Pārbauda, vai šis burts ir spēles vārdā un pareizajā vietā
        if (edt1Text == word1) {
            edt1.setBackgroundColor(Color.parseColor("#5af27d"))
            edt1.isEnabled = false
        }
        if (edt2Text == word2) {
            edt2.setBackgroundColor(Color.parseColor("#5af27d"))
            edt2.isEnabled = false
        }
        if (edt3Text == word3) {
            edt3.setBackgroundColor(Color.parseColor("#5af27d"))
            edt3.isEnabled = false
        }
        if (edt4Text == word4) {
            edt4.setBackgroundColor(Color.parseColor("#5af27d"))
            edt4.isEnabled = false
        }
        if (edt5Text == word5) {
            edt5.setBackgroundColor(Color.parseColor("#5af27d"))
            edt5.isEnabled = false
        }

        // Pārbauda, vai burta nav spēles vārdā
        if (edt1Text != word1 && edt1Text != word2 && edt1Text != word3 && edt1Text != word4 && edt1Text != word5) {
            edt1.setBackgroundColor(Color.parseColor("#808080"))
            edt1.isEnabled = false
        }
        if (edt2Text != word1 && edt2Text != word2 && edt2Text != word3 && edt2Text != word4 && edt2Text != word5) {
            edt2.setBackgroundColor(Color.parseColor("#808080"))
            edt2.isEnabled = false
        }
        if (edt3Text != word1 && edt3Text != word2 && edt3Text != word3 && edt3Text != word4 && edt3Text != word5) {
            edt3.setBackgroundColor(Color.parseColor("#808080"))
            edt3.isEnabled = false
        }
        if (edt4Text != word1 && edt4Text != word2 && edt4Text != word3 && edt4Text != word4 && edt4Text != word5) {
            edt4.setBackgroundColor(Color.parseColor("#808080"))
            edt4.isEnabled = false
        }
        if (edt5Text != word1 && edt5Text != word2 && edt5Text != word3 && edt5Text != word4 && edt5Text != word5) {
            edt5.setBackgroundColor(Color.parseColor("#808080"))
            edt5.isEnabled = false
        }

        // Pārbauda, vai ir ievadīti pareizi visi pieci burti
        if (edt1Text == word1 && edt2Text == word2 && edt3Text == word3 && edt4Text == word4 && edt5Text == word5) {
            // Parāda brīdinājuma ziņojumu "Correct!"
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            // Padara rezultātu tekstu redzamu un iestata to uz "Correct!"
            binding.textResult.visibility = View.VISIBLE
            binding.textResult.text = "Correct!"
            // Izsauc funkciju, lai deaktivētu spēli un parādītu restartēšanas dialogu
            deactivatingGame()
            showRestartDialog()
            return
        }

        // Ja ir ievadīti pieci burti, bet tie nav pareizi
        if (edt5.id == R.id.edt_6_5) {
            // Parāda brīdinājuma ziņojumu ar spēles vārdu
            Toast.makeText(this, "The word was: \n$WORD", Toast.LENGTH_SHORT).show()
            // Padara rezultātu tekstu redzamu un iestata to uz spēles vārdu
            binding.textResult.visibility = View.VISIBLE
            binding.textResult.text = "The word was: \n$WORD"
            // Izsauc funkciju, lai deaktivētu spēli un parādītu restartēšanas dialogu
            deactivatingGame()
            showRestartDialog()
            return
        }
    }
    // Funkcija, kura izveido dialoga logu, lai lietotājs varētu restartēt spēli
    private fun showRestartDialog() {
        // Izveido jaunu dialoga logu
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Restart Game")
        dialogBuilder.setMessage("Do you want to restart the game?")
        // Pievieno pogu "Jā", kas restartē spēli
        dialogBuilder.setPositiveButton("Yes") { dialog, which ->
            // Funkcijas restartGame() izsaukums
            restartGame()
        }
        dialogBuilder.setNegativeButton("No") { dialog, which ->
        }
        // Izveido dialogu, pamatojoties uz dialoga veidotāju
        val dialog = dialogBuilder.create()
        // Parāda dialoga logu
        dialog.show()
    }
    // Funkcija, kura izveido dialoga logu, lai lietotājs varētu ievadīt savu vārdu
    private fun showNameInputDialog() {
        // Izveido jaunu dialoga logu
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enter Your Name")

        // Izveido teksta ievades lauku dialoga logā
        val input = EditText(this)
        input.hint = "Your Name"
        builder.setView(input)

        // Pievieno divus pogus ("OK" un "Cancel") dialoga logam
        builder.setPositiveButton("OK") { dialog, which ->
            userName = input.text.toString()
            // Sveiciens!
            Toast.makeText(applicationContext, "Hello, $userName!", Toast.LENGTH_SHORT).show()
            startGame()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            finish()
        }

        // Noņem iespēju aizvērt dialoga logu, nospiežot ārpus tā
        builder.setCancelable(false)
        // Parāda dialoga logu
        builder.show()
    }

    // Funkcija, kura izveido dialoga logu ar sveicienu un instrukcijām.
    private fun startGame() {
        // Izveido dialoga logu ar nosaukumu "Spēles instrukcijas"
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Game Instructions")
        // Uzstāda ziņu ar sveicienu spēlētājam un instrukcijām
        dialogBuilder.setMessage("Hello $userName! Try to guess the 5-letter word!" +
                "\nYellow means letter is in the word" +
                "\nGreen means the letter is correct and in the right place" +
                "\nGrey means that letter is not in this word")
        // Pievieno pogu "Sākt", kas uzsāks spēli
        dialogBuilder.setPositiveButton("Start") { dialog, which -> }
        // Noņem iespēju aizvērt dialoga logu, nospiežot ārpus tā,
        // lai lietotajs paspētu izlasīt instrukcijas
        dialogBuilder.setCancelable(false)
        // Parāda dialoga logu
        dialogBuilder.show()
    }

    private fun restartGame() {
        // Iepriekšejas spēles rezultāta dzēšana
        binding.textResult.text = ""
        binding.edt11.text.clear()
        binding.edt12.text.clear()
        binding.edt13.text.clear()
        binding.edt14.text.clear()
        binding.edt15.text.clear()
        binding.edt21.text.clear()
        binding.edt22.text.clear()
        binding.edt23.text.clear()
        binding.edt24.text.clear()
        binding.edt25.text.clear()
        binding.edt31.text.clear()
        binding.edt32.text.clear()
        binding.edt33.text.clear()
        binding.edt34.text.clear()
        binding.edt35.text.clear()
        binding.edt41.text.clear()
        binding.edt42.text.clear()
        binding.edt43.text.clear()
        binding.edt44.text.clear()
        binding.edt45.text.clear()
        binding.edt51.text.clear()
        binding.edt52.text.clear()
        binding.edt53.text.clear()
        binding.edt54.text.clear()
        binding.edt55.text.clear()
        binding.edt61.text.clear()
        binding.edt62.text.clear()
        binding.edt63.text.clear()
        binding.edt64.text.clear()
        binding.edt65.text.clear()
        // Baltas krāsas atgriešana laukiem
        binding.edt11.setBackgroundColor(Color.WHITE)
        binding.edt12.setBackgroundColor(Color.WHITE)
        binding.edt13.setBackgroundColor(Color.WHITE)
        binding.edt14.setBackgroundColor(Color.WHITE)
        binding.edt15.setBackgroundColor(Color.WHITE)

        binding.edt21.setBackgroundColor(Color.WHITE)
        binding.edt22.setBackgroundColor(Color.WHITE)
        binding.edt23.setBackgroundColor(Color.WHITE)
        binding.edt24.setBackgroundColor(Color.WHITE)
        binding.edt25.setBackgroundColor(Color.WHITE)

        binding.edt31.setBackgroundColor(Color.WHITE)
        binding.edt32.setBackgroundColor(Color.WHITE)
        binding.edt33.setBackgroundColor(Color.WHITE)
        binding.edt34.setBackgroundColor(Color.WHITE)
        binding.edt35.setBackgroundColor(Color.WHITE)

        binding.edt41.setBackgroundColor(Color.WHITE)
        binding.edt42.setBackgroundColor(Color.WHITE)
        binding.edt43.setBackgroundColor(Color.WHITE)
        binding.edt44.setBackgroundColor(Color.WHITE)
        binding.edt45.setBackgroundColor(Color.WHITE)

        binding.edt51.setBackgroundColor(Color.WHITE)
        binding.edt52.setBackgroundColor(Color.WHITE)
        binding.edt53.setBackgroundColor(Color.WHITE)
        binding.edt54.setBackgroundColor(Color.WHITE)
        binding.edt55.setBackgroundColor(Color.WHITE)

        binding.edt61.setBackgroundColor(Color.WHITE)
        binding.edt62.setBackgroundColor(Color.WHITE)
        binding.edt63.setBackgroundColor(Color.WHITE)
        binding.edt64.setBackgroundColor(Color.WHITE)
        binding.edt65.setBackgroundColor(Color.WHITE)
        // No masīva nejauši izvēlētas vērtības piešķiršana mainīgājai
        WORD = wordsForGame.random()
        // Funkcijas activateGame() izsaukums
        activateGame()
    }
    // Spēles lauka aktivacija, lai lietotājam būtu iepsējas modificēt ievadīto tekstu
    // Tā ieslēdz lauka rediģēšanu, ļaujot rakstīt kaut ko
    private fun activateGame() {
        binding.edt11.isEnabled = true
        binding.edt12.isEnabled = true
        binding.edt13.isEnabled = true
        binding.edt14.isEnabled = true
        binding.edt15.isEnabled = true

        binding.edt21.isEnabled = true
        binding.edt22.isEnabled = true
        binding.edt23.isEnabled = true
        binding.edt24.isEnabled = true
        binding.edt25.isEnabled = true

        binding.edt31.isEnabled = true
        binding.edt32.isEnabled = true
        binding.edt33.isEnabled = true
        binding.edt34.isEnabled = true
        binding.edt35.isEnabled = true

        binding.edt41.isEnabled = true
        binding.edt42.isEnabled = true
        binding.edt43.isEnabled = true
        binding.edt44.isEnabled = true
        binding.edt45.isEnabled = true

        binding.edt51.isEnabled = true
        binding.edt52.isEnabled = true
        binding.edt53.isEnabled = true
        binding.edt54.isEnabled = true
        binding.edt55.isEnabled = true

        binding.edt61.isEnabled = true
        binding.edt62.isEnabled = true
        binding.edt63.isEnabled = true
        binding.edt64.isEnabled = true
        binding.edt65.isEnabled = true
    }
    // Spēles lauka deaktivācija, lai lietotājam nebūtu iepsējas modificēt ievadīto tekstu
    // Tā izslēdz lauka rediģēšanu, neļaujot rakstīt kaut ko jauno tajā
    private fun deactivatingGame() {
        binding.edt11.isEnabled = false
        binding.edt12.isEnabled = false
        binding.edt13.isEnabled = false
        binding.edt14.isEnabled = false
        binding.edt15.isEnabled = false

        binding.edt21.isEnabled = false
        binding.edt22.isEnabled = false
        binding.edt23.isEnabled = false
        binding.edt24.isEnabled = false
        binding.edt25.isEnabled = false

        binding.edt31.isEnabled = false
        binding.edt32.isEnabled = false
        binding.edt33.isEnabled = false
        binding.edt34.isEnabled = false
        binding.edt35.isEnabled = false

        binding.edt41.isEnabled = false
        binding.edt42.isEnabled = false
        binding.edt43.isEnabled = false
        binding.edt44.isEnabled = false
        binding.edt45.isEnabled = false

        binding.edt51.isEnabled = false
        binding.edt52.isEnabled = false
        binding.edt53.isEnabled = false
        binding.edt54.isEnabled = false
        binding.edt55.isEnabled = false

        binding.edt61.isEnabled = false
        binding.edt62.isEnabled = false
        binding.edt63.isEnabled = false
        binding.edt64.isEnabled = false
        binding.edt65.isEnabled = false
    }

    //Fokusa pārslēgšanas funkcijas process
    private fun focusPassingProcess() {
        focusPassing(binding.edt11, binding.edt11, binding.edt12)
        focusPassing(binding.edt11, binding.edt12, binding.edt13)
        focusPassing(binding.edt12, binding.edt13, binding.edt14)
        focusPassing(binding.edt13, binding.edt14, binding.edt15)
        focusPassing(binding.edt14, binding.edt15, binding.edt21)

        focusPassing(binding.edt21, binding.edt21, binding.edt22)
        focusPassing(binding.edt21, binding.edt22, binding.edt23)
        focusPassing(binding.edt22, binding.edt23, binding.edt24)
        focusPassing(binding.edt23, binding.edt24, binding.edt25)
        focusPassing(binding.edt24, binding.edt25, binding.edt31)

        focusPassing(binding.edt31, binding.edt31, binding.edt32)
        focusPassing(binding.edt31, binding.edt32, binding.edt33)
        focusPassing(binding.edt32, binding.edt33, binding.edt34)
        focusPassing(binding.edt33, binding.edt34, binding.edt35)
        focusPassing(binding.edt34, binding.edt35, binding.edt41)

        focusPassing(binding.edt41, binding.edt41, binding.edt42)
        focusPassing(binding.edt41, binding.edt42, binding.edt43)
        focusPassing(binding.edt42, binding.edt43, binding.edt44)
        focusPassing(binding.edt43, binding.edt44, binding.edt45)
        focusPassing(binding.edt44, binding.edt45, binding.edt51)

        focusPassing(binding.edt51, binding.edt51, binding.edt52)
        focusPassing(binding.edt51, binding.edt52, binding.edt53)
        focusPassing(binding.edt52, binding.edt53, binding.edt54)
        focusPassing(binding.edt53, binding.edt54, binding.edt55)
        focusPassing(binding.edt54, binding.edt55, binding.edt61)

        focusPassing(binding.edt61, binding.edt61, binding.edt62)
        focusPassing(binding.edt61, binding.edt62, binding.edt63)
        focusPassing(binding.edt62, binding.edt63, binding.edt64)
        focusPassing(binding.edt63, binding.edt64, binding.edt65)
        focusPassing(binding.edt64, binding.edt65, binding.edt65)
    }
    //Funkcija, kura ļauj pārslēgt fokusu starp trim EditText laukiem pēc teksta ievades,
    //lai lietotājiem būtu ērtāk pārvietoties no viena lauka uz nākamo vai iepriekšējo
    private fun focusPassing(edt0: EditText, edt1: EditText, edt2: EditText) {
        // Pievieno teksta maiņas klausītāju edt1 EditText laukam, lai noteiktu izmaiņas laukā
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(edt: Editable?) {
                // Pēc teksta maiņas - pārbauda teksta garumu
                if (edt?.length ==1) {
                    // Ja teksta garums ir 1, tad pārslēdz fokusu uz nākamo lauku edt2
                    edt2.requestFocus()
                }
                else {
                    // Ja teksta garums nav 1, tad pārslēdz fokusu uz iepriekšējo lauku edt0
                    edt0.requestFocus()
                }
            }
        })
    }

    // Statiskais objekts, kurā glabājas vārdu masīvs un izvēlētais vārds.
    companion object {
        private val wordsForGame = arrayOf(
            // Masīvs ar vārdiem, kas izmantoti spēlei.
            "jazzy", "trait", "funny", "pizza", "funky", "brick",
            "rocks", "whizz", "dizzy", "jewel", "lucky", "jokes",
            "quark", "brush", "hijab", "crazy", "fruit", "fiend",
            "demon", "anger", "angel", "lover", "swift", "quick",
            "unzip", "bravo", "joker", "jeans", "flows", "kayak",
            "drown", "upper", "truly", "false", "forms", "great",
            "mixer", "mixed", "chuck", "music", "tower", "crown",
            "queen", "price", "zones", "hater", "karma", "furry",
            "nukes", "dirty", "scrub", "flame", "props", "pears",
            "apple", "grant", "horse", "groom", "anime", "amaze",
            "house", "botox", "kitty", "puppy", "pumps", "trump",
            "prize", "magic", "click", "mouse", "bacon", "trick",
            "block", "sleep", "dream", "wrong", "whack", "thing",
            "black", "float", "topaz", "sushi", "query", "eases",
            "match", "brats", "clubs", "timer", "poets", "daddy",
            "flesh", "fresh", "guilt", "fixer", "broke", "heart",
            "thank", "think", "glows", "froze", "yarns", "speak",
            "ready", "freak", "hello", "world", "space", "sunny",
            "grump", "throw", "whale", "while", "witch", "coven",
            "gloss", "dread", "roads", "train", "trail", "lever",
            "cores", "sport", "trope", "ropes", "tears", "sting",
            "stone", "water", "bears", "ghost", "blobs", "treat",
            "spine", "chain", "flute", "notes", "broth", "miner")

        // Šajā mainīgajā tiek saglabāts gadījuma vārds no vārdu masīva.
        private var WORD = wordsForGame.random()
    }
}