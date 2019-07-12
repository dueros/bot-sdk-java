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

package com.baidu.dueros.data.response.directive.dpl.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 触发组件动画, 按照设置的属性展示动画效果
 * 
 * @author hujie08(hujie08@baidu.com)
 * @version V1.0
 * @since 2018年4月28日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimationCommand extends BaseCommand {

    // 动画所作用的属性
    private String attribute;
    // 动画作用属性的起始值
    private String from;
    // 动画作用属性的结束值
    private String to;
    // 描述动画执行的速度曲线，用于使动画变化更为平滑
    private EasingType easing = EasingType.LINEAR;
    // 动画执行的时间
    private long duration = 1000;
    // 可选，动画重复的次数
    private String repeatCount = "infinite";
    // 动画重复方式
    private RepeatMode repeatMode = RepeatMode.RESTART;

    public AnimationCommand() {
        super("Animation");
    }

    public String getAttribute() {
        return attribute;
    }

    public AnimationCommand setAttribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public AnimationCommand setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public AnimationCommand setTo(String to) {
        this.to = to;
        return this;
    }

    public EasingType getEasing() {
        return easing;
    }

    public AnimationCommand setEasing(EasingType easing) {
        this.easing = easing;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public AnimationCommand setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public String getRepeatCount() {
        return repeatCount;
    }

    public AnimationCommand setRepeatCount(String repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public RepeatMode getRepeatMode() {
        return repeatMode;
    }

    public AnimationCommand setRepeatMode(RepeatMode repeatMode) {
        this.repeatMode = repeatMode;
        return this;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum EasingType {

        LINEAR("linear"), EASE("ease"), EASEIN("ease-in"), EASEOUT("ease-out");
        private String easing;

        @JsonValue
        public String getEasing() {
            return easing;
        }

        public void setEasing(String easing) {
            this.easing = easing;
        }

        private EasingType(String easing) {
            this.easing = easing;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public enum RepeatMode {
        RESTART("restart"), REVERSE("reverse");

        @JsonValue
        public String getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(String repeatMode) {
            this.repeatMode = repeatMode;
        }

        private String repeatMode;

        private RepeatMode(String repeatMode) {
            this.repeatMode = repeatMode;
        }
    }
}
