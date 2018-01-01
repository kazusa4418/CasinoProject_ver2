package util.playingcard;

import java.util.Comparator;

/**
 * CardSorterOnPoker��List�ȂǂŃ\�[�g���s���ۂɃ\�[�g���@���w�肵�܂��B
 * �\�[�g�����̓|�[�J�[�̃��[���ɏ]���ăJ�[�h�̋�����r���\�[�g���܂��B
 *
 * @author kazusa4418
 * @see Card
 * @see Comparator
 */
public class CardSorterOnPoker implements Comparator<Card> {
    /**
     * �󂯎����2��Card�^�C���X�^���X���r���܂��B
     *
     * @param card1 - ��r����Card�^�C���X�^���X�ł��B
     * @param card2 - ��r�����Card�^�C���X�^���X�ł��B
     * @return ��r����C���X�^���X���召�ɂ����0, 1, -1 �̂����ꂩ���ԋp����܂��B
     */
    public int compare(Card card1, Card card2) {
        if (card1.getNum() == CardNumber.JOKER)
            return 1;
        if (card2.getNum() == CardNumber.JOKER)
            return -1;
        if (card1.getNum() == CardNumber.num1)
            return 1;
        if (card2.getNum() == CardNumber.num1)
            return -1;
        return Integer.compare(card1.strength(), card2.strength());
    }
}
