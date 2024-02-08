package com.example.motivation.data

import com.example.motivation.infrestructure.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.LOOP
    private val face = MotivationConstants.FILTER.FACE
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrases = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", face),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", face),
        Phrase("Quando está mais escuro, vemos mais estrelas!", face),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", face),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", face),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", face),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getPhrase(value: Int): String {
        val filtered = mListPhrases.filter { it.categoryId == value || value == all}
        val index = Random.nextInt(filtered.size)

        return filtered[index].description
    }
}