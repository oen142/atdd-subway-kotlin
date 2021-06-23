package com.wani.subway.study

import org.assertj.core.api.Assertions.assertThat
import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.alg.shortestpath.KShortestPaths
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.WeightedMultigraph
import org.junit.jupiter.api.Test

class JgraphtTest {

    @Test
    fun getDijkstraShortestPath() {
        val source = "v3"
        val target = "v1"

        val graph = WeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge::class.java)
        graph.addVertex("v1")
        graph.addVertex("v2")
        graph.addVertex("v3")

        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2.0)
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2.0)
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100.0)

        val dijkstraShortestPath = DijkstraShortestPath(graph)
        val shortestPath = dijkstraShortestPath.getPath(source, target).vertexList

        assertThat(shortestPath.size).isEqualTo(3)
    }

    @Test
    fun `길찾기 가중치를 검사한다`() {
        val source = "v3"
        val target = "v1"

        val graph = WeightedMultigraph<String, DefaultWeightedEdge>(DefaultWeightedEdge::class.java)
        graph.addVertex("v1")
        graph.addVertex("v2")
        graph.addVertex("v3")
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2.0)
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2.0)
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100.0)

        val paths = KShortestPaths(graph, 100).getPaths(source, target)

        assertThat(paths).hasSize(2)

    }
}