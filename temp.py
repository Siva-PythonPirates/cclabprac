def mapper(line):
    for record in line.split(","):
        year, temp = record.split()
        yield year, int(temp)

def reducer(grouped):
    for year, temps in grouped.items():
        yield year, max(temps)

line = input()
mapped = list(mapper(line))

grouped = {}
for year, temp in mapped:
    grouped.setdefault(year, []).append(temp)
    print(f"{year}\t{temp}")

for result in reducer(grouped):
    print(result)
