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
package com.baidu.dueros.data.response.directive.audioplayer.control;

public class PlayPauseButton extends Button {
    // 按钮名称，为常量PLAY_PAUSE
    private static final String name = "PLAY_PAUSE";

    /**
     * 默认构造方法 参数无，按钮名称为常量PLAY_PAUSE
     */
    public PlayPauseButton() {
        super(name);
    }
}
