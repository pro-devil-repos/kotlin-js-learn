import kotlinx.css.*
import kotlinx.css.properties.*
import styled.StyleSheet

object AppStyles : StyleSheet("AppStyles", isStatic = false) {
    val appContainer by css {
        textAlign = TextAlign.center
    }

    val appLogo by css {
        height = 40.vmin
        pointerEvents = PointerEvents.none

        media("(prefers-reduced-motion: no-preference)") {
            animation(
                "App-logo-spin",
                iterationCount = IterationCount.infinite,
                duration = 20.s,
                timing = Timing.linear
            )
        }
    }

    val appHeader by css {
        backgroundColor = rgb(40, 44, 52)
        minHeight = 100.vh
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
        justifyContent = JustifyContent.center
        fontSize = (10.px + 2.vmin)
        color = Color.white
    }

    val appLink by css {
        color = rgb(97, 218, 251)
    }
}