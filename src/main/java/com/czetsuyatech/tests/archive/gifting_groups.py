# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


def count_groups(related):
    # Write your code here
    count = 0
    length = len(related)

    related = convert_to_array(related)

    for indx in range(length):
        if related[indx][indx] == 1:
            count += 1
            dfs(indx, length, related)

    return count


def dfs(idx, length, matrix):

    if matrix[idx][idx] == 0:
        return

    for i in range(length):
        if matrix[idx][i] == 1:
            matrix[idx][i] = 0
            dfs(i, length, matrix)


def convert_to_array(s):
    result = []
    for char in s:
        result.append([int(x) for x in char])
    return result

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')
    print('result', count_groups(['110', '110', '001']))
    print('result', count_groups(['1100', '1110', '0110', '0001']))
    print('result', count_groups(['11100', '11001', '10100', '00011', '01011']))
    print('result', count_groups(['11100', '11100', '11100', '00011', '00011']))
    print('result', count_groups(['10100', '01010', '10100', '01010', '00001']))

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
