/* 
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.dueros.data.response.directive.audioplayer;

import java.util.ArrayList;

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 渲染音频列表状态的指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonTypeName("Display.RenderAudioList")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenderAudioList extends Directive {
    // 列表的唯一标识
    private String token;
    // 列表的标题
    private String title;
    // 列表的渲染模式
    private RenderAudioListPlayBehaviorType behavior;
    // 列表的总大小。指列表中包含的所有页面的大小的和
    private long size;
    // 列表项目信息
    private ArrayList<RenderAudioListAudioItem> audioItems = new ArrayList<>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RenderAudioListPlayBehaviorType getBehavior() {
        return behavior;
    }

    public void setBehavior(RenderAudioListPlayBehaviorType behavior) {
        this.behavior = behavior;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public ArrayList<RenderAudioListAudioItem> getAudioItems() {
        return audioItems;
    }

    public void setAudioItems(ArrayList<RenderAudioListAudioItem> audioItems) {
        this.audioItems = audioItems;
    }

    public void addAudioItem(RenderAudioListAudioItem audioItem) {
        if (this.audioItems == null) {
            this.audioItems = new ArrayList<RenderAudioListAudioItem>();
        }
        this.audioItems.add(audioItem);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum RenderAudioListPlayBehaviorType {
        // 先清空当前的列表，然后再渲染，适用于首页的第一次渲染场景。
        REPLACE,
        // 当前列表不变，在当前的列表后面渲染，适用于往后翻页的渲染场景。
        APPEND,
        // 当前列表不变，在当前的列表前面渲染，适用于往前翻页的渲染的场景。
        PREPEND,
    }
}
