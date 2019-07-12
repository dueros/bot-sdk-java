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

package com.baidu.dueros.data.response.directive.display;

import java.util.ArrayList;
import java.util.List;

import com.baidu.dueros.data.response.directive.Directive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 用于渲染音频专辑列表的指令
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonTypeName("Display.RenderAlbumList")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenderAlbumList extends Directive {

    // 列表的唯一标识
    private String token;
    // 列表的标题
    private String title;
    // 列表的渲染模式
    private RenderAlbumListPlayBehaviorType behavior;
    // 列表的总大小。指列表中包含的所有页面的大小的和
    private long size;
    // url不需要渲染出来，需要往前翻页
    private String previousPageUrl;
    // url不需要渲染出来，需要往后翻页
    private String nextPageUrl;
    // 专辑列表的类型
    private AlbumListType albumListType;
    private List<Album> albums = new ArrayList<>();

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

    public RenderAlbumListPlayBehaviorType getBehavior() {
        return behavior;
    }

    public void setBehavior(RenderAlbumListPlayBehaviorType behavior) {
        this.behavior = behavior;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPreviousPageUrl() {
        return previousPageUrl;
    }

    public void setPreviousPageUrl(String previousPageUrl) {
        this.previousPageUrl = previousPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public AlbumListType getAlbumListType() {
        return albumListType;
    }

    public void setAlbumListType(AlbumListType albumListType) {
        this.albumListType = albumListType;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        if (this.albums == null) {
            this.albums = new ArrayList<Album>();
        }
        this.albums.add(album);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum RenderAlbumListPlayBehaviorType {
        // 先清空当前的列表，然后再渲染，适用于首页的第一次渲染场景。
        REPLACE,
        // 当前列表不变，在当前的列表后面渲染，适用于往后翻页的渲染场景。
        APPEND,
        // 当前列表不变，在当前的列表前面渲染，适用于往前翻页的渲染的场景。
        PREPEND,
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum AlbumListType {
        // 收藏的专辑列表
        FAVORITE_ALBUM_LIST,
        // 普通的专辑列表
        NORMAL_ALBUM_LIST,
        // 播放历史的专辑列表
        HISTORY_ALBUM_LIST,
    }
}
