package com.uzias.virtualwallet.welcome.presentation.model

import com.uzias.virtualwallet.core.util.InvalidData

data class PresentationUser(val name: String = InvalidData.INVALID.getString(),
                            val email: String = InvalidData.INVALID.getString())