/*
 * Copyright (C) 2019 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3

import java.io.IOException
import okio.BufferedSink

open class ForwardingRequestBody(delegate: RequestBody?) : RequestBody() {
  private val delegate: RequestBody

  fun delegate(): RequestBody {
    return delegate
  }

  override fun contentType(): MediaType? {
    return delegate.contentType()
  }

  @Throws(IOException::class) override fun contentLength(): Long {
    return delegate.contentLength()
  }

  @Throws(IOException::class)
  override fun writeTo(sink: BufferedSink) {
    delegate.writeTo(sink)
  }

  override fun isDuplex(): Boolean {
    return delegate.isDuplex()
  }

  override fun toString(): String {
    return javaClass.simpleName + "(" + delegate.toString() + ")"
  }

  init {
    requireNotNull(delegate) { "delegate == null" }
    this.delegate = delegate
  }
}
