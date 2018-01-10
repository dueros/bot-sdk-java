# 度秘BOT-SDK for Java
这是一个帮助开发Bot的SDK，我们强烈建议您使用这个SDK开发度秘的Bot。当然，您也可以完全自己来处理中控的协议，自己完成session、nlu、result处理，但是度秘的中控对Bot的协议经常会进行升级，这样会给你带来一些麻烦。这个SDK会与中控的协议一起升级，会最大限度减少对您开发bot的影响。

## BOT-SDK提供了以下功能
我们的目标是通过使用bot-sdk，可以迅速的开发一个bot，而不必过多去关注DuerOS的复杂协议。我们提供了如下功能：
* 封装了DuerOS的request和response
* 提供了session的简化接口
* 提供了nlu简化接口
* 提供了多轮对话开发接口
* 提供了事件监听接口

## BOT-SDK安装说明
* BOT-SDK需要Java 8及以上版本
* 建议使用Maven作为工程管理工具，BOT-SDK的升级、维护都将通过Maven进行发布，在pom.xml中添加最新的版本依赖，如下

```java
<dependency>
    <groupId>com.baidu.dueros</groupId>
    <artifactId>bot-sdk</artifactId>
    <version>1.0</version>
</dependency>
```

## BOT-SDK使用说明
BOT-SDK提供了两个简单的例子，分别在com.baidu.dueros.samples.audioplayer和com.baidu.dueros.samples.tax。为了使用BOT-SDK，你需要新建一个Class，比如查询个人所得税的例子TaxBot，根据税前工资、城市计算所要查询的个税，需要继承com.baidu.dueros.bot.BaseBot类。

查询个税的意图为inquiry，槽位分别为monthlysalary（税前工资）、location（城市）、compute_type（个税种类）。关于意图以及槽位的概念见https://dueros.baidu.com/didp/doc/dueros-bot-platform/dbp-nlu/intents_markdown

```java
public class TaxBot extends BaseBot {}
```

开发一个音频播放的Bot，应该继承com.baidu.dueros.bot.AudioPlayer类，AudioPlayer也是继承自BaseBot的子类

```java
public class AudioPlayerBot extends AudioPlayer {}
```

然后，重写BaseBot的构造方法，BaseBot提供了四种基本的构造函数，Bot可以根据自身情况进行重写


```java
// 使用HttpServletRequest作为参数（针对使用Servlet实现服务）
protected BaseBot(HttpServletRequest request) throws IOException {}

// 使用Request作为参数
protected BaseBot(Request request) throws IOException {}

// 使用序列化后的字符串作为参数
protected BaseBot(String request) throws IOException {}

// 使用Certificate对象作为参数，在开启请求参数验证的情况下，需要构造Certificate对象，Certificate的message成语变量是HTTP请求body信息
protected BaseBot(Certificate certificate) throws IOException {}
```

假设TaxBot使用HttpServletRequest作为参数实现构造方法

```java
/**
 * 重写BaseBot构造方法
 */
public TaxBot(HttpServletRequest request) throws IOException {
    super(request);
}
```

### Bot重写多轮对话接口或事件监听接口

#### Bot开始提供服务

```java
/**
 * 重写onLaunch方法，处理onLaunch对话事件
 */
@Override
protected Response onLaunch(LaunchRequest launchRequest) {

    // 新建文本卡片
    TextCard textCard = new TextCard("所得税为您服务");
    // 设置链接地址
    textCard.setUrl("www:....");
    // 设置链接内容
    textCard.setAnchorText("setAnchorText");
    // 添加引导话术
    textCard.addCueWord("欢迎进入");

    // 新建返回的语音内容
    OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "所得税为您服务");

    // 构造返回的Response
    Response response = new Response(outputSpeech, textCard);

    return response;
}
```

#### Bot结束对话

```java
/**
 * 重写onSessionEnded事件，处理onSessionEnded对话事件
 */
@Override
protected Response onSessionEnded(SessionEndedRequest sessionEndedRequest) {

    // 构造TextCard
    TextCard textCard = new TextCard("感谢使用所得税服务");
    textCard.setAnchorText("setAnchorText");
    textCard.addCueWord("欢迎再次使用");

    // 构造OutputSpeech
    OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "欢迎再次使用所得税服务");

    // 构造Response
    Response response = new Response(outputSpeech, textCard);

    return response;
}
```

#### Bot处理NLU解析的意图

```java
/**
 * 重写onInent方法，处理onInent对话事件
 */
@Override
protected Response onInent(IntentRequest intentRequest) {

    // 判断NLU解析的意图名称是否匹配
    if ("myself".equals(intentRequest.getIntentName())) {
        // 判断NLU解析解析后是否存在这个槽位
        if (getSlot("monthlysalary") == null) {
            // 询问月薪槽位
            ask("monthlysalary");
            return askSalary();
        } else if (getSlot("location") == null) {
            // 询问城市槽位
            ask("location");
            return askLocation();
        } else if (getSlot("compute_type") == null) {
            // 询问查询种类槽位
            ask("compute_type");
            return askComputeType();
        } else {
            // 具体计算方法
            compute();
        }
    }

    return null;
}
```

#### Bot还可以订阅端上触发的事件
订阅端上触发的事件，Bot继承com.baidu.dueros.bot.AudioPlayer类，重写处理端上报事件的方法
```java
/**
 * 重写onPlaybackNearlyFinishedEvent方法，处理onPlaybackNearlyFinishedEvent端上报事件
 */
@Override
protected Response onPlaybackNearlyFinishedEvent(PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent) {

    TextCard textCard = new TextCard();
    textCard.setContent("处理即将播放完成事件");
    textCard.setUrl("www:...");
    textCard.setAnchorText("setAnchorText");
    textCard.addCueWord("即将完成");

    OutputSpeech outputSpeech = new OutputSpeech(SpeechType.PlainText, "处理即将播放完成事件");

    // 新建Play指令
    Play play = new Play(PlayBehaviorType.ENQUEUE, "url", 1000);
    // 添加返回的指令
    addDirective(play);

    Reprompt reprompt = new Reprompt(outputSpeech);

    Response response = new Response(outputSpeech, textCard, reprompt);

    return response;
}
```

提供四种类型的端上报事件

```java
// 处理PlaybackStartedEvent事件
protected Response onPlaybackStartedEvent(final PlaybackStartedEvent playbackNearlyFinishedEvent) {}

// 处理PlaybackStoppedEvent事件
protected Response onPlaybackStoppedEvent(final PlaybackStoppedEvent playbackStoppedEvent) {}

// 处理PlaybackNearlyFinishedEvent事件
protected Response onPlaybackNearlyFinishedEvent(final PlaybackNearlyFinishedEvent playbackNearlyFinishedEvent) {}

// 处理PlaybackFinishedEvent事件
protected Response onPlaybackFinishedEvent(final PlaybackFinishedEvent playbackFinishedEvent) {}
```

### 部署服务

以在Tomcat上部署servlet为例，首先新建一个Servlet。
```java
@WebServlet("/tax")
public class TaxAction extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaxAction() {
        super();
    }
}
```

然后重写doPost方法，根据HttpServletRequest构建一个TaxBot对象，然后调用TaxBot的run()方法，run()的返回结果就是bot Response对应的字符串，设置Response的编码为UTF-8，作为servlet的response。

```java
/**
 * 重写doPost方法，处理POST请求
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // 创建Bot
        TaxBot bot = new TaxBot(request);
        // 打开签名验证
        bot.enableVerify();
        // 关闭签名验证
        // bot.disableVerify();

        try {
            // 调用bot的run方法
            String responseJson = bot.run();
            // 设置response的编码UTF-8
            response.setCharacterEncoding("UTF-8");
            // 返回response
            response.getWriter().append(responseJson);
        } catch (Exception e) {
            // 返回非法结果
            response.getWriter().append("{\"status\":1,\"msg\":\"\"}");
        }

    }
```

将上述servlet部署在Tomcat等服务器上，启动服务后即可提供服务


### 使多轮对话管理更加简单

### NLU交互协议
在DBP（DuerOS Bot Platform）平台，可以通过NLU工具，添加了针对槽位询问的配置，包括：
* 是否必选，对应询问的默认话术
* 是否需要用户确认槽位内容，以及对应的话术
* 是否需要用户在执行动作前，对所有的槽位确认一遍，以及对应的话术

针对填槽多轮，Bot发起对用户收集、确认槽位（如果针对特定槽位有设置确认选项，就进行确认）、确认意图（如果有设置确认选项）的询问，BOT-SDK提供了方便的快捷函数支持：

#### ask

多轮对话的Bot，会通过询问用户来收集完成任务所需要的槽位信息，ask就是询问一个特定的槽位，比如查询个税的意图中，没有提供月薪收入，就可以通过ask询问月薪收入。

```java
// 判断NLU解析的意图名称是否匹配
if ("inquiry".equals(intentRequest.getIntentName())) {
    // 判断NLU解析解析后是否存在这个槽位
    if (getSlot("monthlysalary") == null) {
        // 询问月薪槽位
        ask("monthlysalary");
        return askSalary();
    } else if (getSlot("location") == null) {
        // 询问城市槽位
        ask("location");
        return askLocation();
    } else if (getSlot("compute_type") == null) {
        // 询问查询种类槽位
        ask("compute_type");
        return askComputeType();
    } else {
        // 具体计算方法
        compute();
    }
}
```

#### delegate

将处理交给DuerOS的会话管理模块DM（Dialog Management），按事先配置的顺序，包括对缺失槽位的询问，槽位值的确认（如果设置了需要确认，以及确认的话术），整个意图的确认（如果设置了意图需要确认，以及确认的话术）。比如可以将收集的槽位依次列出，等待用户确认。
```java
// 判断NLU解析的意图名称是否匹配
if ("inquiry".equals(intentRequest.getIntentName())) {
    // 如果使用了delegate 就不再需要使用setConfirmSlot/setConfirmIntent，否则返回的directive会被后set的覆盖
    setDelegate();
}
```

#### confirm slot

主动发起对一个槽位的确认，此时还需要同时返回询问的outputSpeech。主动发起的确认，DM不会使用默认配置的话术。

```java
// 判断NLU解析的意图名称是否匹配
if ("inquiry".equals(intentRequest.getIntentName())) {
    // 判断NLU解析解析后是否存在这个槽位
    if (getSlot("monthlysalary") == null) {
        // 确认槽位
        setConfirmSlot("monthlysalary");
    }
}
```


#### confirm intent

主动发起对一个意图的确认，此时还需同时返回询问的outputSpeach。主动发起的确认，DM不会使用默认配置的话术。一般当槽位填槽完毕，在进行下一步操作之前，一次性的询问各个槽位，是否符合用户预期。

```java
// 判断NLU解析的意图名称是否匹配
if ("inquiry".equals(intentRequest.getIntentName())) {
    // 判断NLU解析解析后是否存在这个槽位
    if (getSlot("monthlysalary") != null && getSlot("location") != null) {
        // 确认意图
        setConfirmIntent();
    }
}

```

### 返回卡片

#### 文本卡片
```java
TextCard textCard = new TextCard("您的税前工资是多少呢?");
textCard.setUrl("www:......");
textCard.setAnchorText("链接文本");
textCard.addCueWord("您的税前工资是多少呢?");
```

#### 标准卡片
```java
StandardCard standardCard = new StandardCard("您的税前工资是多少呢?", "您的税前工资是多少呢?");
standardCard.setUrl("www:......");
standardCard.setAnchorText("链接文本");
standardCard.addCueWords("您的税前工资是多少呢?");
standardCard.setImage("图片");
```

#### 列表卡片
```java
StandCardList standCardList = new StandCardList();
standCardList.addStandardCardInfo("您的税前工资是多少呢?", "您的税前工资是多少呢?");
standCardList.addCueWords("您的税前工资是多少呢?");
```

#### 图片卡片
```java
ImageCard imageCard = new ImageCard();
imageCard.addImageCardInfo("图片地址", "缩略图地址");
imageCard.addCueWords("引导话术");
```

### 返回speech

#### outputSpeech
```java
// 构造outputSpeech
OutputSpeech outputSpeech = new OutputSpeech(Type.SSML, "您的税前工资是多少呢?");
```

#### reprompt
```java
// 构造reprompt
Reprompt reprompt = new Reprompt(outputSpeech);
```

### 音乐播放指令

#### 播放指令
```java
// 新建Play指令
Play play = new Play(PlayBehaviorType.ENQUEUE, "url", 1000);
// 添加返回的指令
addDirective(play);
```

#### 暂停指令
```java
// 新建Stop指令
Stop stop = new Stop(PlayBehaviorType.REPLACE_ENQUEUED, "url", 1000);
// 添加返回的指令
addDirective(stop);
```

### 构造Response
```java
Response response = new Response(outputSpeech, textCard, reprompt);
```

### 认证
当DuerOS向Bot发送请求时，Bot需要对收到的请求进行验证，验证方法如下：
获取HTTP请求header中的签名signature、证书地址signaturecerturl以及body信息message。
```java
// 根据签名、证书地址、HTTP body构造Certificate对象
Certificate certificate = new Certificate(message, signature, signaturecerturl);
bot.setCertificate(certificate);
// 打开签名验证
bot.enableVerify();
```
在调试过程中，可以关闭认证
```java
// 关闭签名验证
bot.disableVerify();
```

### 线下调试

在启动sample中的taxbot服务后，可以通过postman发送Request，Request的body内容为,resource/request/inquiry_request，便可以看到Bot的返回。

线下调试可以关闭签名认证。
