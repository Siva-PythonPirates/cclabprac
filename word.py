def mapper(line):
    for word in line.split():
        yield word.lower(), 1

def reducer(grouped):
    for word, counts in grouped.items():
        yield word, sum(counts)

line = input()
mapped = list(mapper(line))

grouped = {}
for word, count in mapped:
    grouped.setdefault(word, []).append(count)
    print(f"{word}\t{count}")

for result in reducer(grouped):
    print(result)
