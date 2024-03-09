package string;

import java.util.ArrayList;
import java.util.List;

/**
 * An IP address is a formatted 32-bit unsigned integer where each group of 8 bits is printed as a decimal number and the dot character '.' splits the groups.

    For example, the binary number 00001111 10001000 11111111 01101011 (spaces added for clarity) formatted as an IP address would be "15.136.255.107".
    A CIDR block is a format used to denote a specific set of IP addresses. It is a string consisting of a base IP address, followed by a slash, followed by a prefix length k.
    The addresses it covers are all the IPs whose first k bits are the same as the base IP address.

    For example, "123.45.67.89/20" is a CIDR block with a prefix length of 20. Any IP address whose binary representation matches 01111011 00101101 0100xxxx xxxxxxxx,
    where x can be either 0 or 1, is in the set covered by the CIDR block.
    You are given a start IP address ip and the number of IP addresses we need to cover n.
    Your goal is to use as few CIDR blocks as possible to cover all the IP addresses in the inclusive range [ip, ip + n - 1] exactly.
    No other IP addresses outside of the range should be covered.

    Return the shortest list of CIDR blocks that covers the range of IP addresses. If there are multiple answers, return any of them.

    Example 1:

    Input: ip = "255.0.0.7", n = 10
    Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
    Explanation:
    The IP addresses that need to be covered are:
    - 255.0.0.7  -> 11111111 00000000 00000000 00000111
    - 255.0.0.8  -> 11111111 00000000 00000000 00001000
    - 255.0.0.9  -> 11111111 00000000 00000000 00001001
    - 255.0.0.10 -> 11111111 00000000 00000000 00001010
    - 255.0.0.11 -> 11111111 00000000 00000000 00001011
    - 255.0.0.12 -> 11111111 00000000 00000000 00001100
    - 255.0.0.13 -> 11111111 00000000 00000000 00001101
    - 255.0.0.14 -> 11111111 00000000 00000000 00001110
    - 255.0.0.15 -> 11111111 00000000 00000000 00001111
    - 255.0.0.16 -> 11111111 00000000 00000000 00010000
    The CIDR block "255.0.0.7/32" covers the first address.
    The CIDR block "255.0.0.8/29" covers the middle 8 addresses (binary format of 11111111 00000000 00000000 00001xxx).
    The CIDR block "255.0.0.16/32" covers the last address.
    Note that while the CIDR block "255.0.0.0/28" does cover all the addresses, it also includes addresses outside of the range, so we cannot use it.
 */
public class Ip2Cidr {
   public List<String> ipToCIDR(String ip, int n) {
        long x = 0;
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; ++i) {
            x = x * 256 + Integer.parseInt(ips[i]);
        }

        List<String> res = new ArrayList<>();

        while (n > 0) {
            long lowest_set_bit = x & -x;
            // corner case "0.0.0.0"
            if (lowest_set_bit == 0) {
                lowest_set_bit = (1L << 32);
            }

            while (lowest_set_bit > n) {
                lowest_set_bit /= 2;
            }

            // good to search from here for `lowest_set_bit` steps
            res.add(longToCidr(x, lowest_set_bit));
            x += lowest_set_bit;
            n -= lowest_set_bit;
        }
        return res;
    }

    private String longToCidr(long x, long k) {
        long block_1 = x & 255;
        x >>= 8;
        long block_2 = x & 255;
        x >>= 8;
        long block_3 = x & 255;
        x >>= 8;
        long block_4 = x;
        int len = 0;
        while (k > 0) {
            k /= 2;
            len++;
        }
        return String.valueOf(block_4) + "." + String.valueOf(block_3) + "." + String.valueOf(block_2) + "." + String.valueOf(block_1) + "/" + (32 - len + 1);
    }
}
