
package examples.`10_OPENRNDR_Extras`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.colorBuffer

import org.openrndr.extensions.SingleScreenshot
import org.openrndr.extra.noise.*
import org.openrndr.extra.noise.filters.CellNoise
import org.openrndr.extra.noise.filters.HashNoise
import org.openrndr.extra.noise.filters.SpeckleNoise
import org.openrndr.extra.noise.filters.ValueNoise
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import kotlin.math.abs

fun main(args: Array<String>) {
    application {
        program {
            val cb = colorBuffer(width, height)
            val hn = HashNoise()
            extend {
                hn.seed = seconds
                hn.apply(emptyArray(), cb)
                drawer.image(cb)
            }
        }
    }
}
    