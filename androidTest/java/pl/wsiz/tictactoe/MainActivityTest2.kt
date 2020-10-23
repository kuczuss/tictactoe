package pl.wsiz.tictactoe

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest2{
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun checkButton2(){
    Espresso.onView(ViewMatchers.withText("Two Players")).perform(ViewActions.click())
    Thread.sleep(5000L)
    }
}