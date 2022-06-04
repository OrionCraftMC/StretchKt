package io.github.orioncraftmc.sprawlkt.tests.generated

import io.github.orioncraftmc.sprawlkt.geometry.Size
import io.github.orioncraftmc.sprawlkt.geometry.Size.Companion.undefinedNumber
import io.github.orioncraftmc.sprawlkt.node.Sprawl
import io.github.orioncraftmc.sprawlkt.node.Sprawl.computeLayout
import io.github.orioncraftmc.sprawlkt.node.Sprawl.layout
import io.github.orioncraftmc.sprawlkt.node.Sprawl.newNode
import io.github.orioncraftmc.sprawlkt.style.enums.*
import kotlin.Unit
import kotlin.test.Test

public class FlexBasisSmallerThenContentWithFlexGrowLargeSizeTest {
  @Test
  public fun flex_basis_smaller_then_content_with_flex_grow_large_size(): Unit {
    val node1 = newNode(
            io.github.orioncraftmc.sprawlkt.style.Style
        (
        	size = io.github.orioncraftmc.sprawlkt.geometry.Size(
              width = StretchDimension.Points(70.0f),
              height = StretchDimension.Points(100.0f),
           ),
        ),
            listOf(),
        )
    val node2 = newNode(
            io.github.orioncraftmc.sprawlkt.style.Style
        (
        	flexDirection = FlexDirection.Column,
        	flexGrow = 1.0f,
        	flexBasis = StretchDimension.Points(0.0f),
        ),
            listOf(node1),
        )
    val node3 = newNode(
            io.github.orioncraftmc.sprawlkt.style.Style
        (
        	size = io.github.orioncraftmc.sprawlkt.geometry.Size(
              width = StretchDimension.Points(20.0f),
              height = StretchDimension.Points(100.0f),
           ),
        ),
            listOf(),
        )
    val node4 = newNode(
            io.github.orioncraftmc.sprawlkt.style.Style
        (
        	flexDirection = FlexDirection.Column,
        	flexGrow = 1.0f,
        	flexBasis = StretchDimension.Points(0.0f),
        ),
            listOf(node3),
        )
    val rootNode = newNode(
            io.github.orioncraftmc.sprawlkt.style.Style
        (
        	size = io.github.orioncraftmc.sprawlkt.geometry.Size(
              width = StretchDimension.Points(100.0f),
              height = StretchDimension.Auto,
           ),
        ),
            listOf(node2, node4),
        )
    // {"style":{"flexDirection":"row","size":{"width":{"unit":"Points","value":100}}},"layout":{"width":100,"height":100,"x":0,"y":0},"children":[{"style":{"flexDirection":"column","flexGrow":1,"flexBasis":{"unit":"Points","value":0}},"layout":{"width":70,"height":100,"x":0,"y":0},"children":[{"style":{"size":{"width":{"unit":"Points","value":70},"height":{"unit":"Points","value":100}}},"layout":{"width":70,"height":100,"x":0,"y":0},"children":[]}]},{"style":{"flexDirection":"column","flexGrow":1,"flexBasis":{"unit":"Points","value":0}},"layout":{"width":30,"height":100,"x":70,"y":0},"children":[{"style":{"size":{"width":{"unit":"Points","value":20},"height":{"unit":"Points","value":100}}},"layout":{"width":20,"height":100,"x":0,"y":0},"children":[]}]}]}
    Sprawl.computeLayout(rootNode, Size.Companion.undefinedNumber())
    kotlin.test.assertEquals(100.0f, Sprawl.layout(rootNode).size.width)
    kotlin.test.assertEquals(100.0f, Sprawl.layout(rootNode).size.height)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(rootNode).location.x)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(rootNode).location.y)
    kotlin.test.assertEquals(70.0f, Sprawl.layout(node2).size.width)
    kotlin.test.assertEquals(100.0f, Sprawl.layout(node2).size.height)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node2).location.x)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node2).location.y)
    kotlin.test.assertEquals(70.0f, Sprawl.layout(node1).size.width)
    kotlin.test.assertEquals(100.0f, Sprawl.layout(node1).size.height)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node1).location.x)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node1).location.y)
    kotlin.test.assertEquals(30.0f, Sprawl.layout(node4).size.width)
    kotlin.test.assertEquals(100.0f, Sprawl.layout(node4).size.height)
    kotlin.test.assertEquals(70.0f, Sprawl.layout(node4).location.x)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node4).location.y)
    kotlin.test.assertEquals(20.0f, Sprawl.layout(node3).size.width)
    kotlin.test.assertEquals(100.0f, Sprawl.layout(node3).size.height)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node3).location.x)
    kotlin.test.assertEquals(0.0f, Sprawl.layout(node3).location.y)
  }
}