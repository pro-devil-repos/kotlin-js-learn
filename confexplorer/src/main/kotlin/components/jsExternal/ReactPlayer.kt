@file:JsModule("react-player")
@file:JsNonModule

package components.jsExternal

import react.*

external interface ReactPlayerProps : RProps {
    var url: String
}

@JsName("default")
external val reactPlayer: RClass<ReactPlayerProps>