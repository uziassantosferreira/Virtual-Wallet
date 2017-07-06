package com.uzias.virtualwallet.user.domain.model

import com.uzias.virtualwallet.core.util.InvalidData

data class User(val name: String = InvalidData.INVALID.getString(),
                val email: String = InvalidData.INVALID.getString())