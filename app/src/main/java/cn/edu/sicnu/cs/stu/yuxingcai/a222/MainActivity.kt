package cn.edu.sicnu.cs.stu.yuxingcai.a222

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var textViewCount = 0
    // 实例化Model层
    private val model = ProgramAdviserModel()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化View
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val containerLayout = findViewById<LinearLayout>(R.id.container_layout)
        val btnConfirm = findViewById<Button>(R.id.btn_confirm)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        // ================= 区1逻辑：动态添加TextView =================
        btnAdd.setOnClickListener {
            textViewCount++

            // 动态生成TextView
            val newTextView = TextView(this).apply {
                // 使用字符串资源，禁止硬编码
                val prefix = getString(R.string.textview_prefix)
                text = "$prefix$textViewCount"
                textSize = 18f
                setPadding(10, 10, 10, 10)
            }

            // 添加到ScrollView内的LinearLayout中
            containerLayout.addView(newTextView)
        }

        // ================= 区2逻辑：MVC模式 =================
        btnConfirm.setOnClickListener {
            // 1. Controller调用Model获取数据
            val recommendedLang = model.getNextLanguage()

            // 2. 更新View层显示
            tvResult.text = recommendedLang
        }
    }
}