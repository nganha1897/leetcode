class Solution:
    def maxScore(self, s: str) -> int:
        zeros = 0
        leng = len(s)
        maxScore = 0
        for i in s:
            zeros += 1 if i == '0' else 0

        curZeros = 0
        for idx, i in enumerate(s[:-1]):
            curZeros += 1 if i == '0' else 0
            maxScore = max(maxScore, curZeros + leng - idx - 1 - (zeros - curZeros))
        
        return maxScore

            