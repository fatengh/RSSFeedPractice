package com.example.rssfeedpractice

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream


class XMLParser {
    private val questions = ArrayList<Question>()
    private var text: String? = null
    private var qTitle = ""
    private var qAuther = ""

    fun parse(inputStream: InputStream): List<Question> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("title", ignoreCase = true) -> {
                            qTitle = text.toString()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            qAuther = text.toString()
                        }
                        tagName.equals("entry", ignoreCase = true) -> {
                            questions.add(Question(qTitle, qAuther))
                        }
                        else -> {
                        }
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return questions
    }

}