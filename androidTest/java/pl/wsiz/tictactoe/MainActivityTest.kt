package pl.wsiz.tictactoe

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun checkButton(){
    onView(withText("One Player")).perform(click())
        Thread.sleep(5000L)
    }
}