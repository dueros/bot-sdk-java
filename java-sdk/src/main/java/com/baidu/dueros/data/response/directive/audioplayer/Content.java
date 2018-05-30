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

/**
 * 用于生成playerinfo中的content信息
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version 1.0
 * @since 2018年4月27日
 */
public class Content {
    // 音频类型
    private AudioItemType audioItemType = AudioItemType.MUSIC;
    // 音频的标题，比如歌曲名
    private String title = "";
    // 音频子标题1，比如歌手名
    private String titleSubtext1 = "";
    // 音频子标题2，比如专辑名
    private String titleSubtext2 = "";
    // 歌词的结构
    private LyricStructure lyric;
    // 音频流的长度，单位为ms
    private Long mediaLengthInMilliseconds = 0L;
    // 音频封面图片
    private ImageStructure art;
    // 资源提供方信息
    private Provider provider = new Provider();

    /**
     * 默认构造函数 设置类型为音乐
     */
    public Content() {
        this.audioItemType = AudioItemType.MUSIC;
    }

    /**
     * content的构造函数
     * 
     * @param title
     *            音频标题，如歌曲名
     * @param lyric
     *            歌词url
     * @param mediaLengthInMilliseconds
     *            音频流长度(ms)
     */
    public Content(String title, String lyric, Long mediaLengthInMilliseconds) {
        this.title = title;
        this.lyric = new LyricStructure(lyric);
        this.mediaLengthInMilliseconds = mediaLengthInMilliseconds;
    }

    /**
     * 获取音频类型的getter方法
     * 
     * @return AudioItemType 音频类型
     */
    public AudioItemType getAudioItemType() {
        return audioItemType;
    }

    /**
     * 音频类型的setter方法
     * 
     * @param audioItemType
     *            音频的类型
     * @return Content
     */
    public Content setAudioItemType(AudioItemType audioItemType) {
        this.audioItemType = audioItemType;
        return this;
    }

    /**
     * 获取音频标题的getter，比如歌曲名
     * 
     * @return String 音频标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置音频标题的setter方法， 比如歌曲名
     * 
     * @param title
     *            音频标题
     * @return Content
     */
    public Content setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 获取音频子标题1的getter，比如歌手名
     * 
     * @return String 音频子标题1
     */
    public String getTitleSubtext1() {
        return titleSubtext1;
    }

    /**
     * 设置音频子标题1的setter，比如歌手名
     * 
     * @param titleSubtext1
     *            音频子标题1
     * @return Content
     */
    public Content setTitleSubtext1(String titleSubtext1) {
        this.titleSubtext1 = titleSubtext1;
        return this;
    }

    /**
     * 获取音频子标题2的getter，比如专辑名
     * 
     * @return String 音频子标题2
     */
    public String getTitleSubtext2() {
        return titleSubtext2;
    }

    /**
     * 设置音频子标题2的setter，比如专辑名
     * 
     * @param titleSubtext2
     *            音频子标题2
     * @return Content
     */
    public Content setTitleSubtext2(String titleSubtext2) {
        this.titleSubtext2 = titleSubtext2;
        return this;
    }

    /**
     * 获取歌词的getter方法
     * 
     * @return LyricStructure 歌词结构体
     */
    public LyricStructure getLyric() {
        return lyric;
    }

    /**
     * 设置歌词的setter方法
     * 
     * @param lyric
     *            歌词结构体LyricStructure
     * @return Content
     */
    public Content setLyric(LyricStructure lyric) {
        this.lyric = lyric;
        return this;
    }

    /**
     * 设置歌词的setter方法
     * 
     * @param lyricUrl
     *            歌词地址
     * @return Content
     */
    public Content setLyric(String lyricUrl) {
        lyric = new LyricStructure(lyricUrl);
        return this;
    }

    /**
     * 获取音频流长度的getter方法，单位为ms
     * 
     * @return Long 音频流长度(ms)
     */
    public Long getMediaLengthInMilliseconds() {
        return mediaLengthInMilliseconds;
    }

    /**
     * 设置音频流长度的setter方法，单位为ms
     * 
     * @param mediaLengthInMilliseconds
     *            音频流长度(ms)
     * @return Content
     */
    public Content setMediaLengthInMilliseconds(Long mediaLengthInMilliseconds) {
        this.mediaLengthInMilliseconds = mediaLengthInMilliseconds;
        return this;
    }

    /**
     * 获取音频封面图片的getter方法
     * 
     * @return ImageStructure 音频封面图片
     */
    public ImageStructure getArt() {
        return art;
    }

    /**
     * 设置音频封面图片的setter方法
     * 
     * @param art
     *            封面图片结构体 ImageStructure
     * @return Content
     */
    public Content setArt(ImageStructure art) {
        this.art = art;
        return this;
    }

    /**
     * 设置音频封面图片地址
     * 
     * @param art
     *            封面图片url地址
     * @return Content
     */
    public Content setArt(String art) {
        this.art = new ImageStructure(art);
        return this;
    }

    /**
     * 获取资源提供方信息的getter方法
     * 
     * @return Provider 资源提供方信息
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * 设置资源提供方信息的setter方法
     * 
     * @param provider
     *            资源提供方信息
     * @return Content
     */
    public Content setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    /**
     * 设置资源提供方信息
     * 
     * @param name
     *            资源提供方的名字
     * @param logo
     *            资源提供方的logo的url
     * @return Content
     */
    public Content setProvider(String name, String logo) {
        provider = new Provider(name, logo);
        return this;
    }

    /**
     * 音频的类型定义
     */
    public enum AudioItemType {
        // 音乐
        MUSIC,
        // 音乐MV
        MUSIC_VIDEO,
        // 直播电台，比如AM和FM
        RADIO,
        // 有声资源，比如相声等
        UNICAST,
        // 新闻
        NEWS,
        // 笑话
        JOKE
    }

    /**
     * 歌词的格式定义
     */
    public static enum LyricFormat {
        LRC
    }

    /**
     * 歌词的结构定义
     * 
     * @author hujie08
     * @version 1.0
     * @since 2018年4月27日
     */
    public class LyricStructure {
        // url只能返回http地址, 歌词地址
        public String url = "";
        // 歌词格式
        public LyricFormat format;

        /**
         * 默认构造函数
         */
        public LyricStructure() {
            this.format = LyricFormat.LRC;
        }

        /**
         * 构造函数
         * 
         * @param url
         *            歌词地址
         */
        public LyricStructure(String url) {
            this();
            this.url = url;
        }

        /**
         * 构造函数
         * 
         * @param url
         *            歌词地址
         * @param format
         *            歌词格式
         */
        public LyricStructure(String url, LyricFormat format) {
            this.url = url;
            this.format = format;
        }

        /**
         * 获取歌词的url的getter方法
         * 
         * @return String 歌词地址
         */
        public String getUrl() {
            return url;
        }

        /**
         * 设置歌词url的setter方法
         * 
         * @param url
         *            歌词地址
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 获取歌词的格式的getter方法
         * 
         * @return LyricFormat 歌曲格式
         */
        public LyricFormat getFormat() {
            return format;
        }

        /**
         * 设置歌词各种的setter方法
         * 
         * @param format
         *            歌词格式
         */
        public void setFormat(LyricFormat format) {
            this.format = format;
        }
    }

    /**
     * 图片结构体
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version 1.0
     * @since 2018年4月27日
     */
    public class ImageStructure {
        // 图片地址
        public String src = "";

        /**
         * 图片结构信息的构造函数
         */
        public ImageStructure() {
        }

        /**
         * 图片结构信息的构造函数
         * 
         * @param src
         *            图片地址
         */
        public ImageStructure(String src) {
            this.src = src;
        }

        /**
         * 获取图片地址的getter方法
         * 
         * @return 图片地址
         */
        public String getSrc() {
            return src;
        }

        /**
         * 设置图片地址的setter方法
         * 
         * @param src
         *            图片地址
         */
        public void setSrc(String src) {
            this.src = src;
        }

    }

    /**
     * 资源提供方信息
     * 
     * @author hujie08(hujie08@baidu.com)
     * @version 1.0
     * @since 2018年4月27日
     */
    public class Provider {
        // 资源提供方的名字
        public String name;
        // 资源提供方的logo
        public ImageStructure logo;

        /**
         * 默认构造函数
         */
        public Provider() {
        }

        /**
         * 构造函数
         * 
         * @param name
         *            资源提供方的名字
         */
        public Provider(String name) {
            this.name = name;
        }

        /**
         * 构造函数
         * 
         * @param name
         *            资源提供方的名字
         * @param logoUrl
         *            资源提供方的logo的图片地址
         */
        public Provider(String name, String logoUrl) {
            this(name);
            ImageStructure logo = new ImageStructure(logoUrl);
            this.logo = logo;
        }

        /**
         * 构造函数
         * 
         * @param name
         *            资源提供方的名字
         * @param logo
         *            资源提供方的logo(ImageStructure)
         */
        public Provider(String name, ImageStructure logo) {
            this.name = name;
            this.logo = logo;
        }

        /**
         * 获取资源提供方名字的getter方法
         * 
         * @return String 资源提供方名字
         */
        public String getName() {
            return name;
        }

        /**
         * 设置资源提供方名字的setter方法
         * 
         * @param name
         *            资源提供方名字
         * @return Provider
         */
        public Provider setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * 获取资源提供方logo的getter方法
         * 
         * @return ImageStructure 资源提供方logo
         */
        public ImageStructure getLogo() {
            return logo;
        }

        /**
         * 设置资源提供方logo的setter方法
         * 
         * @param logo
         *            资源提供方logo
         * @return Provider
         */
        public Provider setLogo(ImageStructure logo) {
            this.logo = logo;
            return this;
        }
    }
}
