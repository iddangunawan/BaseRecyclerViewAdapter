/*
 * Copyright (C) 2018 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.baserecyclerviewadapterdemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.baserecyclerviewadapterdemo.MockSamples
import com.skydoves.baserecyclerviewadapterdemo.R
import com.skydoves.baserecyclerviewadapterdemo.adapter.SampleAdapter1
import com.skydoves.baserecyclerviewadapterdemo.model.SampleItem
import com.skydoves.baserecyclerviewadapterdemo.viewholder.SampleViewHolder
import kotlinx.android.synthetic.main.activity_sample1.*
import org.jetbrains.anko.toast

class SampleActivity1 : AppCompatActivity(), SampleViewHolder.Delegate {

  private val adapter by lazy { SampleAdapter1(this) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_sample1)

    sample1_recyclerView.adapter = adapter
    sample1_recyclerView.layoutManager = LinearLayoutManager(this)

    for (i in 0..5) {
      adapter.addItems(i, MockSamples.mockSampleItems(this, 3))
    }
  }

  override fun onItemClick(sampleItem: SampleItem) {
    toast(sampleItem.name)
  }
}
