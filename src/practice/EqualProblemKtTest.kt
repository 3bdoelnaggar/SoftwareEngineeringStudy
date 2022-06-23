package practice

import org.junit.Test

import kotlin.test.assertEquals

internal class EqualProblemKtTest {

    @Test
    fun test1() {
        val bigInput = arrayOf(
            53,
            361,
            188,
            665,
            786,
            898,
            447,
            562,
            272,
            123,
            229,
            629,
            670,
            848,
            994,
            54,
            822,
            46,
            208,
            17,
            449,
            302,
            466,
            832,
            931,
            778,
            156,
            39,
            31,
            777,
            749,
            436,
            138,
            289,
            453,
            276,
            539,
            901,
            839,
            811,
            24,
            420,
            440,
            46,
            269,
            786,
            101,
            443,
            832,
            661,
            460,
            281,
            964,
            278,
            465,
            247,
            408,
            622,
            638,
            440,
            751,
            739,
            876,
            889,
            380,
            330,
            517,
            919,
            583,
            356,
            83,
            959,
            129,
            875,
            5,
            750,
            662,
            106,
            193,
            494,
            120,
            653,
            128,
            84,
            283,
            593,
            683,
            44,
            567,
            321,
            484,
            318,
            412,
            712,
            559,
            792,
            394,
            77,
            711,
            977,
            785,
            146,
            936,
            914,
            22,
            942,
            664,
            36,
            400,
            857
        )
        assertEquals(ramyEqual3(bigInput),10605)


    }

    @Test
    fun test2() {
        val input = arrayOf(2, 2, 3, 7)
        assertEquals(ramyEqual3(input), 2)
    }

    @Test
    fun test3() {
        val input = arrayOf(10, 7, 12)
        assertEquals(ramyEqual3(input), 3)
    }

    @Test
    fun test4() {
        val input = arrayOf(1, 1, 5)
        assertEquals(ramyEqual3(input), 2)
    }

    @Test
    fun test5() {
        val input = arrayOf(1, 5, 5)
        assertEquals(ramyEqual3(input), 3)
    }

    @Test
    fun test6() {
        val input = arrayOf(2, 5, 5, 5, 5, 5)
        assertEquals(ramyEqual3(input), 6)
    }

    @Test
    fun test7(){
        val stringInput="761 706 697 212 97 845 151 637 102 165 200 34 912 445 435 53 12 255 111 565 816 632 534 617 18 786 790 802 253 502 602 15 208 651 227 305 848 730 294 303 895 846 337 159 291 125 565 655 380 28 221 549 13 107 166 31 245 308 185 498 810 139 865 370 790 444 27 639 174 321 294 421 168 631 933 811 756 498 467 137 878 40 686 891 499 204 274 744 512 460 242 674 599 108 396 742 552 423 733 79 96 27 852 264 658 785 76 415 635 895 904 514 935 942 757 434 498 32 178 10 844 772 36 795 880 432 537 785 855 270 864 951 649 716 568 308 854 996 75 489 891 331 355 178 273 113 612 771 497 142 133 341 914 521 488 147 953 26 284 160 648 500 463 298 568 31 958 422 379 385 264 622 716 619 800 341 732 764 464 581 258 949 922 173 470 411 672 423 789 956 583 789 808 46 439 376 430 749 151"
        val input=stringInput.split(" ").map {
            it.toInt()
        }.toTypedArray()
        assertEquals(ramyEqual3(input),18762)
    }

    @Test
    fun test8(){
        val stringInput ="1 5 5 10 10"
        val input=stringInput.split(" ").map {
            it.toInt()
        }.toTypedArray()
        assertEquals(ramyEqual3(input),7)
    }
}