package com.dxn.retrofit.util

import com.dxn.retrofit.model.Post
import com.dxn.retrofit.network.PostDto

object ModelMapper {
    private fun networkEntityToModel(postDto: PostDto ) : Post {
        return Post(
            id = postDto.id,
            userId = postDto.userId,
            title = postDto.title,
            body = postDto.body
        )
    }

    private fun modelToNetworkEntity( post: Post ) : PostDto {
        return PostDto(
            id = post.id,
            userId = post.userId,
            title = post.title,
            body = post.body
        )
    }

    fun networkEntityListToModelList(postDtoList: List<PostDto> ) : List<Post> {
        val postList = mutableListOf<Post>();
        postDtoList.forEach(){ networkEntity ->
            postList.add(networkEntityToModel(networkEntity))
        }
        return postList
    }
}