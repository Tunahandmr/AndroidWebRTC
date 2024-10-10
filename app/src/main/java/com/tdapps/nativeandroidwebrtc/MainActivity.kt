package com.tdapps.nativeandroidwebrtc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.permissionx.guolindev.PermissionX
import com.tdapps.nativeandroidwebrtc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.enterBtn.setOnClickListener {
            PermissionX.init(this)
                .permissions(
                    android.Manifest.permission.RECORD_AUDIO,
                    android.Manifest.permission.CAMERA
                ).request { allGranted, _, _ ->
                    if (allGranted) {
                        startActivity(
                            Intent(this, CallActivity::class.java)
                                .putExtra("username", binding.username.text.toString())
                        )
                    } else {
                        Toast.makeText(this, "you should accept all permissions", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }
}