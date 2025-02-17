
package examples.`11_Advanced_Topics`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.ComputeShader
import org.openrndr.draw.ImageAccess
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.loadImage
import org.openrndr.extensions.SingleScreenshot
import java.io.File

fun main(args: Array<String>) {
    application {
        program {
            val cs = ComputeShader.fromFile(File("data/compute-shaders/fill.cs"))
            val result = colorBuffer(width, height)
            val testRGBa = colorBuffer(640, 480)
            val test = loadImage("data/images/cheeta.jpg")
            test.copyTo(testRGBa)
        
            extend {
                cs.uniform("fill", ColorRGBa.PINK.shade(0.1))
                cs.image("inputImg", 1, testRGBa, ImageAccess.READ)
                cs.image("outputImg", 0, result, ImageAccess.WRITE)
                cs.execute(result.width, result.height, 1)
                drawer.image(result)
            }
        }
    }
}
    