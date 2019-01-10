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

package com.baidu.dueros.data.request;

import com.baidu.dueros.data.request.supportedInterfaces.Alerts;
import com.baidu.dueros.data.request.supportedInterfaces.AudioPlayer;
import com.baidu.dueros.data.request.supportedInterfaces.Display;
import com.baidu.dueros.data.request.supportedInterfaces.PlayController;
import com.baidu.dueros.data.request.supportedInterfaces.ScreenExtendedCard;
import com.baidu.dueros.data.request.supportedInterfaces.SpeakerController;
import com.baidu.dueros.data.request.supportedInterfaces.TextInput;
import com.baidu.dueros.data.request.supportedInterfaces.VideoPlayer;
import com.baidu.dueros.data.request.supportedInterfaces.VoiceInput;
import com.baidu.dueros.data.request.supportedInterfaces.VoiceOutput;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SupportedInterfaces {

    private TextInput textInput;
    private VoiceInput voiceInput;
    private VoiceOutput voiceOutput;
    private PlayController playController;
    private AudioPlayer audioPlayer;
    private Alerts alerts;
    private com.baidu.dueros.data.request.supportedInterfaces.Screen screen;
    private SpeakerController speakerController;
    private com.baidu.dueros.data.request.supportedInterfaces.System system;
    private ScreenExtendedCard screenExtendedCard;
    private VideoPlayer videoPlayer;
    private Display display;

    public static Builder newBuild() {
        return new Builder();
    }

    public SupportedInterfaces(Builder builder) {
        textInput = builder.textInput;
        voiceInput = builder.voiceInput;
        voiceOutput = builder.voiceOutput;
        playController = builder.playController;
        audioPlayer = builder.audioPlayer;
        alerts = builder.alerts;
        screen = builder.screen;
        speakerController = builder.speakerController;
        system = builder.system;
        screenExtendedCard = builder.screenExtendedCard;
        videoPlayer = builder.videoPlayer;
        display = builder.display;
    }

    public SupportedInterfaces(@JsonProperty("TextInput") TextInput textInput,
            @JsonProperty("VoiceInput") VoiceInput voiceInput, @JsonProperty("VoiceOutput") VoiceOutput voiceOutput,
            @JsonProperty("PlayController") PlayController playController,
            @JsonProperty("AudioPlayer") AudioPlayer audioPlayer, @JsonProperty("Alerts") Alerts alerts,
            @JsonProperty("Screen") com.baidu.dueros.data.request.supportedInterfaces.Screen screen,
            @JsonProperty("SpeakerController") SpeakerController speakerController,
            @JsonProperty("System") com.baidu.dueros.data.request.supportedInterfaces.System system,
            @JsonProperty("ScreenExtendedCard") ScreenExtendedCard screenExtendedCard,
            @JsonProperty("VideoPlayer") VideoPlayer videoPlayer, @JsonProperty("Display") Display display) {
        this.voiceInput = voiceInput;
        this.textInput = textInput;
        this.voiceOutput = voiceOutput;
        this.playController = playController;
        this.audioPlayer = audioPlayer;
        this.alerts = alerts;
        this.screen = screen;
        this.speakerController = speakerController;
        this.system = system;
        this.screenExtendedCard = screenExtendedCard;
        this.videoPlayer = videoPlayer;
        this.display = display;
    }

    public TextInput getTextInput() {
        return textInput;
    }

    public VoiceInput getVoiceInput() {
        return voiceInput;
    }

    public VoiceOutput getVoiceOutput() {
        return voiceOutput;
    }

    public PlayController getPlayController() {
        return playController;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public Alerts getAlerts() {
        return alerts;
    }

    public com.baidu.dueros.data.request.supportedInterfaces.Screen getScreen() {
        return screen;
    }

    public SpeakerController getSpeakerController() {
        return speakerController;
    }

    public com.baidu.dueros.data.request.supportedInterfaces.System getSystem() {
        return system;
    }

    public ScreenExtendedCard getScreenExtendedCard() {
        return screenExtendedCard;
    }

    public VideoPlayer getVideoPlayer() {
        return videoPlayer;
    }

    public Display getDisplay() {
        return display;
    }

    public static final class Builder {

        private TextInput textInput;
        private VoiceInput voiceInput;
        private VoiceOutput voiceOutput;
        private PlayController playController;
        private AudioPlayer audioPlayer;
        private Alerts alerts;
        private com.baidu.dueros.data.request.supportedInterfaces.Screen screen;
        private SpeakerController speakerController;
        private com.baidu.dueros.data.request.supportedInterfaces.System system;
        private ScreenExtendedCard screenExtendedCard;
        private VideoPlayer videoPlayer;
        private Display display;

        public Builder setTextInput(TextInput textInput) {
            this.textInput = textInput;
            return this;
        }

        public Builder setVoiceInput(VoiceInput voiceInput) {
            this.voiceInput = voiceInput;
            return this;
        }

        public Builder setVoiceOutput(VoiceOutput voiceOutput) {
            this.voiceOutput = voiceOutput;
            return this;
        }

        public Builder setPlayController(PlayController playController) {
            this.playController = playController;
            return this;
        }

        public Builder setAudioPlayer(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
            return this;
        }

        public Builder setAlerts(Alerts alerts) {
            this.alerts = alerts;
            return this;
        }

        public Builder setScreen(com.baidu.dueros.data.request.supportedInterfaces.Screen screen) {
            this.screen = screen;
            return this;
        }

        public Builder setSpeakerController(SpeakerController speakerController) {
            this.speakerController = speakerController;
            return this;
        }

        public Builder setSystem(com.baidu.dueros.data.request.supportedInterfaces.System system) {
            this.system = system;
            return this;
        }

        public Builder setScreenExtendedCard(ScreenExtendedCard screenExtendedCard) {
            this.screenExtendedCard = screenExtendedCard;
            return this;
        }

        public Builder setVideoPlayer(VideoPlayer videoPlayer) {
            this.videoPlayer = videoPlayer;
            return this;
        }

        public Builder setDisplay(Display display) {
            this.display = display;
            return this;
        }

        public SupportedInterfaces build() {
            return new SupportedInterfaces(this);
        }
    }
}
