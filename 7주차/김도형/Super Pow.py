class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        return (a % 1337)**(1140 + int(''.join(map(str, b))) % 1140) % 1337
