package com.sandeep.datastore

import androidx.datastore.core.Serializer
import java.io.InputStream
import java.io.OutputStream

object UserProtoDataStoreSerializer : Serializer<UserProto> {
    override val defaultValue: UserProto
        get() = UserProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserProto {
        return UserProto.parseFrom(input)
    }

    override suspend fun writeTo(t: UserProto, output: OutputStream) {
        t.writeTo(output)
    }
}