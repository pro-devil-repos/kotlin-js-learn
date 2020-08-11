import react.*
import react.dom.code
import react.dom.p
import styled.*

external interface AppProps : RProps {
    var name: String
}

private val App = functionalComponent<AppProps> { _ ->

    styledDiv {
        css {
            +AppStyles.appContainer
        }

        styledHeader {
            css {
                +AppStyles.appHeader
            }

            styledImg(src = "/logo.svg") {
                css {
                    +AppStyles.appLogo
                }
            }

            p {
                +"Edit "
                code {
                    +"src/App.js"
                }
                +" and save to reload."
            }

            styledA(href = "https://reactjs.org", target = "blank") {
                css {
                    +AppStyles.appLink
                }
                +"Learn React"
            }
        }
    }
}

fun RBuilder.app(handler: AppProps.() -> Unit): ReactElement {
    return child(App) {
        attrs {
            handler()
        }
    }
}