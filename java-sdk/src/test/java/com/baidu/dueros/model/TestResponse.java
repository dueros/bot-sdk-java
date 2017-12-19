/**
 * Copyright (C) 2017 Baidu Inc. All rights reserved.
 */
package com.baidu.dueros.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.baidu.dueros.data.response.OutputSpeech;
import com.baidu.dueros.data.response.OutputSpeech.Type;
import com.baidu.dueros.data.response.Reprompt;
import com.baidu.dueros.data.response.card.Card;
import com.baidu.dueros.data.response.card.TextCard;

import junit.framework.Assert;

/**
 * Response 测试类
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年12月8日
 */
public class TestResponse {

    private Response response = null;
    private OutputSpeech outputSpeech = new OutputSpeech(Type.PlainText, "This is outputspeech");
    private Card card = new TextCard("This is a text card!");
    private Reprompt reprompt = new Reprompt(outputSpeech);

    /**
     * 
     * @param TODO
     * @throws TODO
     * @return void
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * 
     * @param TODO
     * @throws TODO
     * @return void
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * 
     * @param TODO
     * @throws TODO
     * @return void
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link com.baidu.dueros.model.Response#Response()}.
     */
    @Test
    public void testResponse() {
        response = new Response();
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#Response(com.baidu.dueros.data.response.OutputSpeech)}
     * .
     */
    @Test
    public void testResponseOutputSpeech() {
        response = new Response(outputSpeech);
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#Response(com.baidu.dueros.data.response.OutputSpeech, com.baidu.dueros.data.response.card.Card)}
     * .
     */
    @Test
    public void testResponseOutputSpeechCard() {
        response = new Response(outputSpeech, card);
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#Response(com.baidu.dueros.data.response.OutputSpeech, com.baidu.dueros.data.response.card.Card, com.baidu.dueros.data.response.Reprompt)}
     * .
     */
    @Test
    public void testResponseOutputSpeechCardReprompt() {
        response = new Response(outputSpeech, card, reprompt);
    }

    /**
     * Test method for {@link com.baidu.dueros.model.Response#getReprompt()}.
     */
    @Test
    public void testGetReprompt() {
        response = new Response();
        response.setReprompt(reprompt);
        Assert.assertEquals(response.getReprompt(), reprompt);
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#setReprompt(com.baidu.dueros.data.response.Reprompt)}
     * .
     */
    @Test
    public void testSetReprompt() {
        response = new Response();
        response.setReprompt(reprompt);
        Assert.assertEquals(reprompt, response.getReprompt());
    }

    /**
     * Test method for {@link com.baidu.dueros.model.Response#getOutputSpeech()}
     * .
     */
    @Test
    public void testGetOutputSpeech() {
        response = new Response(outputSpeech);
        Assert.assertEquals(response.getOutputSpeech(), outputSpeech);
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#setOutputSpeech(com.baidu.dueros.data.response.OutputSpeech)}
     * .
     */
    @Test
    public void testSetOutputSpeech() {
        response = new Response();
        response.setOutputSpeech(outputSpeech);
        Assert.assertEquals(response.getOutputSpeech(), outputSpeech);
    }

    /**
     * Test method for {@link com.baidu.dueros.model.Response#getCard()}.
     */
    @Test
    public void testGetCard() {
        response = new Response(outputSpeech, card, reprompt);
        Assert.assertEquals(response.getCard(), card);
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#setCard(com.baidu.dueros.data.response.card.Card)}
     * .
     */
    @Test
    public void testSetCard() {
        response = new Response();
        response.setCard(card);
        Assert.assertEquals(response.getCard(), card);
    }

    /**
     * Test method for {@link com.baidu.dueros.model.Response#getResource()}.
     */
    @Test
    public void testGetResource() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link com.baidu.dueros.model.Response#setResource(com.baidu.dueros.data.response.Resource)}
     * .
     */
    @Test
    public void testSetResource() {
        fail("Not yet implemented");
    }

}
