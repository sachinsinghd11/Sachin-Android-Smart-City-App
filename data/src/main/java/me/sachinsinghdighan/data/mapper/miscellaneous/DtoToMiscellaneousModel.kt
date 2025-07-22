package me.sachinsinghdighan.data.mapper.miscellaneous

import me.sachinsinghdighan.data.remote.MiscellaneousDto
import me.sachinsinghdighan.domain.model.miscellaneous.Miscellaneous

fun MiscellaneousDto.toMiscellaneousModel(): Miscellaneous {
    return Miscellaneous(
        id = id,
        imageIcon = imageIcon,
        title = title
    )
}