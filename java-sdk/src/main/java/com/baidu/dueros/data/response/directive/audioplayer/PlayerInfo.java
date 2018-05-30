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

import com.baidu.dueros.data.response.directive.audioplayer.Content.AudioItemType;
import com.baidu.dueros.data.response.directive.audioplayer.Content.LyricStructure;
import com.baidu.dueros.data.response.directive.audioplayer.control.BaseButton;

/**
 * 用于生成PlayerInfo的类
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
public class PlayerInfo {
    // 渲染音频界面的相关信息
    private Content content = new Content();
    // 控件列表
    private ArrayList<BaseButton> controls = new ArrayList<>();

    /**
     * 默认构造函数
     */
    public PlayerInfo() {
    }

    /**
     * playerinfo 的构造函数
     * 
     * @param content
     *            渲染关于音频内容的key/value属性对
     * @param controls
     *            控件列表
     */
    public PlayerInfo(Content content, ArrayList<BaseButton> controls) {
        this.content = content;
        this.controls = controls;
    }

    /**
     * 获取渲染音频界面的相关信息的getter方法
     * 
     * @return Content 渲染音频界面的相关信息
     */
    public Content getContent() {
        return content;
    }

    /**
     * 设置渲染音频界面的相关信息的setter方法
     * 
     * @param content
     *            渲染音频界面的信息类实例
     * @return PlayerInfo
     */
    public PlayerInfo setContent(Content content) {
        this.content = content;
        return this;
    }

    /**
     * 获取控件列表的getter方法
     * 
     * @return ArrayList 控件列表
     */
    public ArrayList<BaseButton> getControls() {
        return controls;
    }

    /**
     * 设置控件列表的setter方法
     * 
     * @param controls
     *            控件列表
     * @return PlayerInfo
     */
    public PlayerInfo setControls(ArrayList<BaseButton> controls) {
        this.controls = controls;
        return this;
    }

    /**
     * 添加控件的代码
     * 
     * @param button
     *            按钮控件
     * @return PlayerInfo
     */
    public PlayerInfo addButton(BaseButton button) {
        controls.add(button);
        return this;
    }

    /**
     * 设置音频类型
     * 
     * @param audioItemType
     *            音频的类型
     * @return PlayerInfo
     */
    public PlayerInfo setAudioItemType(AudioItemType audioItemType) {
        content.setAudioItemType(audioItemType);
        return this;
    }

    /**
     * 设置音频标题的方法， 比如歌曲名
     * 
     * @param title
     *            音频标题
     * @return PlayerInfo 播放器界面信息
     */
    public PlayerInfo setTitle(String title) {
        content.setTitle(title);
        return this;
    }

    /**
     * 设置音频子标题1的方法，比如歌手名
     * 
     * @param titleSubtext1
     *            音频子标题1
     * @return PlayerInfo 播放器界面信息
     */
    public PlayerInfo setTitleSubtext1(String titleSubtext1) {
        content.setTitleSubtext1(titleSubtext1);
        return this;
    }

    /**
     * 设置音频子标题2的方法，比如专辑名
     * 
     * @param titleSubtext2
     *            音频子标题2
     * @return PlayerInfo 播放器界面信息
     */
    public PlayerInfo setTitleSubtext2(String titleSubtext2) {
        content.setTitleSubtext2(titleSubtext2);
        return this;
    }

    /**
     * 设置歌词的方法
     * 
     * @param lyric
     *            歌词结构体LyricStructure
     * @return PlayerInfo 播放器界面信息
     */
    public PlayerInfo setLyric(LyricStructure lyric) {
        content.setLyric(lyric);
        return this;
    }

    /**
     * 设置歌词的方法
     * 
     * @param lyricUrl
     *            歌词地址
     * @return PlayerInfo
     */
    public PlayerInfo setLyric(String lyricUrl) {
        content.setLyric(lyricUrl);
        return this;
    }

    /**
     * 设置音频流长度的setter方法，单位为ms
     * 
     * @param mediaLengthInMilliseconds
     *            音频流长度(ms)
     * @return PlayerInfo
     */
    public PlayerInfo setMediaLengthInMilliseconds(Long mediaLengthInMilliseconds) {
        content.setMediaLengthInMilliseconds(mediaLengthInMilliseconds);
        return this;
    }

}
