package cn.edu.sicnu.cs.stu.yuxingcai.a222

class ProgramAdviserModel {
    // 模拟数据源
    private val languages = arrayOf("kotlin", "Java", "Python", "C++", "JavaScript")
    private var currentIndex = 0

    // 获取下一个推荐语言
    fun getNextLanguage(): String {
        val result = languages[currentIndex]
        currentIndex = (currentIndex + 1) % languages.size
        return result
    }
}
