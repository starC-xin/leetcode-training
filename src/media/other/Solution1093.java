package media.other;

import utils.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2023/5/27
 * 1093. 大样本统计
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
 *
 * 计算以下统计数据:
 *
 * minimum ：样本中的最小元素。
 * maximum ：样品中的最大元素。
 * mean ：样本的平均值，计算为所有元素的总和除以元素总数。
 * median ：
 * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
 * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
 * mode ：样本中出现次数最多的数字。保众数是 唯一 的。
 * 以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10-5 内的答案都可以通过。
 * @author x.z
 */
public class Solution1093 {
    public double[] sampleStats(int[] count) {
        double[] result = new double[]{255, 0, 0, 0, 0};
        long sum = 0;
        int countTotal = 0;
        int maxCount = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0){
//                min
                if(result[0] == 255){
                    result[0] = i;
                }
//                max
                if(result[1] < i){
                    result[1] = i;
                }

//                sum
                sum += (long) count[i] * i;
                countTotal += count[i];

//                median-pre
                list.add(new int[]{i, count[i]});

//                mode
                if(maxCount < count[i]){
                    maxCount = count[i];
                    result[4] = i;
                }
            }
        }
        result[2] = sum * 1.0 / countTotal;
        int half = countTotal / 2;
        int tmp = 0;
        if(countTotal % 2 == 0){
            for (int i = 0; i < list.size(); i++) {
                int[] item = list.get(i);
                tmp += item[1];
                if(tmp > half){
                    result[3] = item[0];
                    break;
                }else if(tmp == half){
                    result[3] = (list.get(i + 1)[0] + item [0]) / 2.0;
                    break;
                }
            }
        }else{
            for (int[] item : list) {
                tmp += item[1];
                if (tmp > half + 1 || tmp == half + 1) {
                    result[3] = item[0];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Solution1093 demo = new Solution1093();

        final double[] doubles = demo.sampleStats(Common.string2IntArr("[2725123,2529890,2612115,3807943,3002363,3107290,2767526,981092,896521,2576757,2808163,3315813,2004022,2516900,607052,1203189,2907162,1849193,1486120,743035,3621726,3366475,639843,3836904,462733,2614577,1881392,85099,709390,3534613,360309,404975,715871,2258745,1682843,3725079,564127,1893839,2793387,2236577,522108,1183512,859756,3431566,907265,1272267,2261055,2234764,1901434,3023329,863353,2140290,2221702,623198,955635,304443,282157,3133971,1985993,1113476,2092502,2896781,1245030,2681380,2286852,3423914,3549428,2720176,2832468,3608887,174642,1437770,1545228,650920,2357584,3037465,3674038,2450617,578392,622803,3206006,3685232,2687252,1001246,3865843,2755767,184888,2543886,2567950,1755006,249516,3241670,1422728,809805,955992,415481,26094,2757283,995334,3713918,2772540,2719728,1204666,1590541,2962447,779517,1322374,1675147,3146304,2412486,902468,259007,3161334,1735554,2623893,1863961,520352,167827,3654335,3492218,1449347,1460253,983079,1135,208617,969433,2669769,284741,1002734,3694338,2567646,3042965,3186843,906766,2755956,2075889,1241484,3790012,2037406,2776032,1123633,2537866,3028339,3375304,1621954,2299012,1518828,1380554,2083623,3521053,1291275,180303,1344232,2122185,2519290,832389,1711223,2828198,2747583,789884,2116590,2294299,1038729,1996529,600580,184130,3044375,261274,3041086,3473202,2318793,2967147,2506188,127448,290011,3868450,1659949,3662189,1720152,25266,1126602,1015878,2635566,619797,2898869,3470795,2226675,2348104,2914940,1907109,604482,2574752,1841777,880254,616721,3786049,2278898,3797514,1328854,1881493,1802018,3034791,3615171,400080,2277949,221689,1021253,544372,3101480,1155691,3730276,1827138,3621214,2348383,2305429,313820,36481,2581470,2794393,902504,2589859,740480,2387513,2716342,1914543,3219912,1865333,2388350,3525289,3758988,961406,1539328,448809,1326527,1339048,2924378,2715811,376047,3642811,2973602,389167,1026011,3633833,2848596,3353421,1426817,219995,1503946,2311246,2618861,1497325,3758762,2115273,3238053,2419849,2545790]"));
        System.out.println(Arrays.toString(doubles));
    }
}
