	.file	"main.cpp"
	.text
.Ltext0:
	.local	_ZStL8__ioinit
	.comm	_ZStL8__ioinit,1,1
	.globl	_Z4testv
	.type	_Z4testv, @function
_Z4testv:
.LFB971:
	.file 1 "main.cpp"
	.loc 1 5 0
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$40, %esp
.LBB2:
	.loc 1 6 0
	movl	$10, -12(%ebp)
	.loc 1 7 0
	movl	-12(%ebp), %eax
	movl	%eax, 4(%esp)
	movl	$_ZSt4cout, (%esp)
	call	_ZNSolsEi
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, 4(%esp)
	movl	%eax, (%esp)
	call	_ZNSolsEPFRSoS_E
	.loc 1 8 0
	addl	$1, -12(%ebp)
	.loc 1 9 0
	movl	-12(%ebp), %eax
	movl	%eax, 4(%esp)
	movl	$_ZSt4cout, (%esp)
	call	_ZNSolsEi
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, 4(%esp)
	movl	%eax, (%esp)
	call	_ZNSolsEPFRSoS_E
.LBE2:
	.loc 1 10 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE971:
	.size	_Z4testv, .-_Z4testv
	.globl	main
	.type	main, @function
main:
.LFB972:
	.loc 1 12 0
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	andl	$-16, %esp
	subl	$32, %esp
.LBB3:
	.loc 1 13 0
	movl	$10, 28(%esp)
	.loc 1 14 0
	movl	28(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$_ZSt4cout, (%esp)
	call	_ZNSolsEi
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, 4(%esp)
	movl	%eax, (%esp)
	call	_ZNSolsEPFRSoS_E
	.loc 1 15 0
	addl	$1, 28(%esp)
	.loc 1 16 0
	movl	28(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$_ZSt4cout, (%esp)
	call	_ZNSolsEi
	movl	$_ZSt4endlIcSt11char_traitsIcEERSt13basic_ostreamIT_T0_ES6_, 4(%esp)
	movl	%eax, (%esp)
	call	_ZNSolsEPFRSoS_E
.LBE3:
	.loc 1 17 0
	movl	$0, %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE972:
	.size	main, .-main
	.type	_Z41__static_initialization_and_destruction_0ii, @function
_Z41__static_initialization_and_destruction_0ii:
.LFB978:
	.loc 1 17 0
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$24, %esp
	.loc 1 17 0
	cmpl	$1, 8(%ebp)
	jne	.L4
	.loc 1 17 0 is_stmt 0 discriminator 1
	cmpl	$65535, 12(%ebp)
	jne	.L4
	.file 2 "/usr/include/c++/4.8/iostream"
	.loc 2 74 0 is_stmt 1
	movl	$_ZStL8__ioinit, (%esp)
	call	_ZNSt8ios_base4InitC1Ev
	movl	$__dso_handle, 8(%esp)
	movl	$_ZStL8__ioinit, 4(%esp)
	movl	$_ZNSt8ios_base4InitD1Ev, (%esp)
	call	__cxa_atexit
.L4:
	.loc 1 17 0
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE978:
	.size	_Z41__static_initialization_and_destruction_0ii, .-_Z41__static_initialization_and_destruction_0ii
	.type	_GLOBAL__sub_I__Z4testv, @function
_GLOBAL__sub_I__Z4testv:
.LFB979:
	.loc 1 17 0
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	subl	$24, %esp
	.loc 1 17 0
	movl	$65535, 4(%esp)
	movl	$1, (%esp)
	call	_Z41__static_initialization_and_destruction_0ii
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
.LFE979:
	.size	_GLOBAL__sub_I__Z4testv, .-_GLOBAL__sub_I__Z4testv
	.section	.init_array,"aw"
	.align 4
	.long	_GLOBAL__sub_I__Z4testv
	.text
.Letext0:
	.file 3 "/usr/include/stdio.h"
	.file 4 "/usr/lib/gcc/i686-linux-gnu/4.8/include/stdarg.h"
	.file 5 "/usr/lib/gcc/i686-linux-gnu/4.8/include/stddef.h"
	.file 6 "/usr/include/wchar.h"
	.file 7 "/usr/include/c++/4.8/cwchar"
	.file 8 "/usr/include/c++/4.8/bits/char_traits.h"
	.file 9 "/usr/include/i386-linux-gnu/c++/4.8/bits/c++config.h"
	.file 10 "/usr/include/c++/4.8/clocale"
	.file 11 "/usr/include/c++/4.8/bits/ios_base.h"
	.file 12 "/usr/include/c++/4.8/cwctype"
	.file 13 "/usr/include/c++/4.8/iosfwd"
	.file 14 "/usr/include/time.h"
	.file 15 "/usr/include/c++/4.8/ext/new_allocator.h"
	.file 16 "/usr/include/c++/4.8/ext/numeric_traits.h"
	.file 17 "/usr/include/c++/4.8/debug/debug.h"
	.file 18 "/usr/include/locale.h"
	.file 19 "/usr/include/i386-linux-gnu/bits/types.h"
	.file 20 "/usr/include/i386-linux-gnu/c++/4.8/bits/atomic_word.h"
	.file 21 "/usr/include/wctype.h"
	.file 22 "<built-in>"
	.section	.debug_info,"",@progbits
.Ldebug_info0:
	.long	0x14aa
	.value	0x4
	.long	.Ldebug_abbrev0
	.byte	0x4
	.uleb128 0x1
	.long	.LASF251
	.byte	0x4
	.long	.LASF252
	.long	.LASF253
	.long	.Ltext0
	.long	.Letext0-.Ltext0
	.long	.Ldebug_line0
	.uleb128 0x2
	.long	.LASF254
	.uleb128 0x3
	.long	.LASF0
	.byte	0x3
	.byte	0x40
	.long	0x25
	.uleb128 0x3
	.long	.LASF1
	.byte	0x4
	.byte	0x28
	.long	0x40
	.uleb128 0x4
	.byte	0x4
	.long	.LASF255
	.long	0x4a
	.uleb128 0x5
	.byte	0x1
	.byte	0x6
	.long	.LASF3
	.uleb128 0x3
	.long	.LASF2
	.byte	0x5
	.byte	0xd4
	.long	0x5c
	.uleb128 0x5
	.byte	0x4
	.byte	0x7
	.long	.LASF4
	.uleb128 0x6
	.long	.LASF5
	.byte	0x5
	.value	0x161
	.long	0x5c
	.uleb128 0x7
	.byte	0x8
	.byte	0x6
	.byte	0x53
	.long	.LASF256
	.long	0xb3
	.uleb128 0x8
	.byte	0x4
	.byte	0x6
	.byte	0x56
	.long	0x9a
	.uleb128 0x9
	.long	.LASF6
	.byte	0x6
	.byte	0x58
	.long	0x5c
	.uleb128 0x9
	.long	.LASF7
	.byte	0x6
	.byte	0x5c
	.long	0xb3
	.byte	0
	.uleb128 0xa
	.long	.LASF8
	.byte	0x6
	.byte	0x54
	.long	0xca
	.byte	0
	.uleb128 0xa
	.long	.LASF9
	.byte	0x6
	.byte	0x5d
	.long	0x7b
	.byte	0x4
	.byte	0
	.uleb128 0xb
	.long	0x4a
	.long	0xc3
	.uleb128 0xc
	.long	0xc3
	.byte	0x3
	.byte	0
	.uleb128 0x5
	.byte	0x4
	.byte	0x7
	.long	.LASF10
	.uleb128 0xd
	.byte	0x4
	.byte	0x5
	.string	"int"
	.uleb128 0x3
	.long	.LASF11
	.byte	0x6
	.byte	0x5e
	.long	0x6f
	.uleb128 0x3
	.long	.LASF12
	.byte	0x6
	.byte	0x6a
	.long	0xd1
	.uleb128 0x5
	.byte	0x2
	.byte	0x7
	.long	.LASF13
	.uleb128 0xe
	.long	0xca
	.uleb128 0xf
	.byte	0x4
	.long	0xf9
	.uleb128 0xe
	.long	0x4a
	.uleb128 0x10
	.string	"std"
	.byte	0x16
	.byte	0
	.long	0x84b
	.uleb128 0x11
	.byte	0x7
	.byte	0x40
	.long	0xdc
	.uleb128 0x11
	.byte	0x7
	.byte	0x8b
	.long	0x63
	.uleb128 0x11
	.byte	0x7
	.byte	0x8d
	.long	0x84b
	.uleb128 0x11
	.byte	0x7
	.byte	0x8e
	.long	0x861
	.uleb128 0x11
	.byte	0x7
	.byte	0x8f
	.long	0x87d
	.uleb128 0x11
	.byte	0x7
	.byte	0x90
	.long	0x8aa
	.uleb128 0x11
	.byte	0x7
	.byte	0x91
	.long	0x8c5
	.uleb128 0x11
	.byte	0x7
	.byte	0x92
	.long	0x8eb
	.uleb128 0x11
	.byte	0x7
	.byte	0x93
	.long	0x906
	.uleb128 0x11
	.byte	0x7
	.byte	0x94
	.long	0x922
	.uleb128 0x11
	.byte	0x7
	.byte	0x95
	.long	0x93e
	.uleb128 0x11
	.byte	0x7
	.byte	0x96
	.long	0x954
	.uleb128 0x11
	.byte	0x7
	.byte	0x97
	.long	0x960
	.uleb128 0x11
	.byte	0x7
	.byte	0x98
	.long	0x986
	.uleb128 0x11
	.byte	0x7
	.byte	0x99
	.long	0x9ab
	.uleb128 0x11
	.byte	0x7
	.byte	0x9a
	.long	0x9cc
	.uleb128 0x11
	.byte	0x7
	.byte	0x9b
	.long	0x9f7
	.uleb128 0x11
	.byte	0x7
	.byte	0x9c
	.long	0xa12
	.uleb128 0x11
	.byte	0x7
	.byte	0x9e
	.long	0xa28
	.uleb128 0x11
	.byte	0x7
	.byte	0xa0
	.long	0xa49
	.uleb128 0x11
	.byte	0x7
	.byte	0xa1
	.long	0xa65
	.uleb128 0x11
	.byte	0x7
	.byte	0xa2
	.long	0xa80
	.uleb128 0x11
	.byte	0x7
	.byte	0xa4
	.long	0xaa0
	.uleb128 0x11
	.byte	0x7
	.byte	0xa7
	.long	0xac0
	.uleb128 0x11
	.byte	0x7
	.byte	0xaa
	.long	0xae5
	.uleb128 0x11
	.byte	0x7
	.byte	0xac
	.long	0xb05
	.uleb128 0x11
	.byte	0x7
	.byte	0xae
	.long	0xb20
	.uleb128 0x11
	.byte	0x7
	.byte	0xb0
	.long	0xb3b
	.uleb128 0x11
	.byte	0x7
	.byte	0xb1
	.long	0xb61
	.uleb128 0x11
	.byte	0x7
	.byte	0xb2
	.long	0xb7b
	.uleb128 0x11
	.byte	0x7
	.byte	0xb3
	.long	0xb95
	.uleb128 0x11
	.byte	0x7
	.byte	0xb4
	.long	0xbaf
	.uleb128 0x11
	.byte	0x7
	.byte	0xb5
	.long	0xbc9
	.uleb128 0x11
	.byte	0x7
	.byte	0xb6
	.long	0xbe3
	.uleb128 0x11
	.byte	0x7
	.byte	0xb7
	.long	0xca3
	.uleb128 0x11
	.byte	0x7
	.byte	0xb8
	.long	0xcb9
	.uleb128 0x11
	.byte	0x7
	.byte	0xb9
	.long	0xcd8
	.uleb128 0x11
	.byte	0x7
	.byte	0xba
	.long	0xcf7
	.uleb128 0x11
	.byte	0x7
	.byte	0xbb
	.long	0xd16
	.uleb128 0x11
	.byte	0x7
	.byte	0xbc
	.long	0xd41
	.uleb128 0x11
	.byte	0x7
	.byte	0xbd
	.long	0xd5c
	.uleb128 0x11
	.byte	0x7
	.byte	0xbf
	.long	0xd84
	.uleb128 0x11
	.byte	0x7
	.byte	0xc1
	.long	0xda6
	.uleb128 0x11
	.byte	0x7
	.byte	0xc2
	.long	0xdc6
	.uleb128 0x11
	.byte	0x7
	.byte	0xc3
	.long	0xded
	.uleb128 0x11
	.byte	0x7
	.byte	0xc4
	.long	0xe14
	.uleb128 0x11
	.byte	0x7
	.byte	0xc5
	.long	0xe33
	.uleb128 0x11
	.byte	0x7
	.byte	0xc6
	.long	0xe49
	.uleb128 0x11
	.byte	0x7
	.byte	0xc7
	.long	0xe69
	.uleb128 0x11
	.byte	0x7
	.byte	0xc8
	.long	0xe89
	.uleb128 0x11
	.byte	0x7
	.byte	0xc9
	.long	0xea9
	.uleb128 0x11
	.byte	0x7
	.byte	0xca
	.long	0xec9
	.uleb128 0x11
	.byte	0x7
	.byte	0xcb
	.long	0xee0
	.uleb128 0x11
	.byte	0x7
	.byte	0xcc
	.long	0xef7
	.uleb128 0x11
	.byte	0x7
	.byte	0xcd
	.long	0xf15
	.uleb128 0x11
	.byte	0x7
	.byte	0xce
	.long	0xf34
	.uleb128 0x11
	.byte	0x7
	.byte	0xcf
	.long	0xf52
	.uleb128 0x11
	.byte	0x7
	.byte	0xd0
	.long	0xf71
	.uleb128 0x12
	.byte	0x7
	.value	0x108
	.long	0x10ca
	.uleb128 0x12
	.byte	0x7
	.value	0x109
	.long	0x10ec
	.uleb128 0x12
	.byte	0x7
	.value	0x10a
	.long	0x1113
	.uleb128 0x13
	.long	.LASF257
	.byte	0x11
	.byte	0x30
	.uleb128 0x14
	.long	.LASF140
	.byte	0x1
	.byte	0x8
	.byte	0xe9
	.long	0x485
	.uleb128 0x3
	.long	.LASF14
	.byte	0x8
	.byte	0xeb
	.long	0x4a
	.uleb128 0x3
	.long	.LASF15
	.byte	0x8
	.byte	0xec
	.long	0xca
	.uleb128 0x15
	.long	.LASF27
	.byte	0x8
	.byte	0xf2
	.long	.LASF258
	.long	0x2fa
	.uleb128 0x16
	.long	0x1162
	.uleb128 0x16
	.long	0x1168
	.byte	0
	.uleb128 0xe
	.long	0x2ca
	.uleb128 0x17
	.string	"eq"
	.byte	0x8
	.byte	0xf6
	.long	.LASF16
	.long	0x116e
	.long	0x31c
	.uleb128 0x16
	.long	0x1168
	.uleb128 0x16
	.long	0x1168
	.byte	0
	.uleb128 0x17
	.string	"lt"
	.byte	0x8
	.byte	0xfa
	.long	.LASF17
	.long	0x116e
	.long	0x339
	.uleb128 0x16
	.long	0x1168
	.uleb128 0x16
	.long	0x1168
	.byte	0
	.uleb128 0x18
	.long	.LASF18
	.byte	0x8
	.byte	0xfe
	.long	.LASF176
	.long	0xca
	.long	0x35c
	.uleb128 0x16
	.long	0x1175
	.uleb128 0x16
	.long	0x1175
	.uleb128 0x16
	.long	0x485
	.byte	0
	.uleb128 0x19
	.long	.LASF19
	.byte	0x8
	.value	0x102
	.long	.LASF21
	.long	0x485
	.long	0x376
	.uleb128 0x16
	.long	0x1175
	.byte	0
	.uleb128 0x19
	.long	.LASF20
	.byte	0x8
	.value	0x106
	.long	.LASF22
	.long	0x1175
	.long	0x39a
	.uleb128 0x16
	.long	0x1175
	.uleb128 0x16
	.long	0x485
	.uleb128 0x16
	.long	0x1168
	.byte	0
	.uleb128 0x19
	.long	.LASF23
	.byte	0x8
	.value	0x10a
	.long	.LASF24
	.long	0x117b
	.long	0x3be
	.uleb128 0x16
	.long	0x117b
	.uleb128 0x16
	.long	0x1175
	.uleb128 0x16
	.long	0x485
	.byte	0
	.uleb128 0x19
	.long	.LASF25
	.byte	0x8
	.value	0x10e
	.long	.LASF26
	.long	0x117b
	.long	0x3e2
	.uleb128 0x16
	.long	0x117b
	.uleb128 0x16
	.long	0x1175
	.uleb128 0x16
	.long	0x485
	.byte	0
	.uleb128 0x19
	.long	.LASF27
	.byte	0x8
	.value	0x112
	.long	.LASF28
	.long	0x117b
	.long	0x406
	.uleb128 0x16
	.long	0x117b
	.uleb128 0x16
	.long	0x485
	.uleb128 0x16
	.long	0x2ca
	.byte	0
	.uleb128 0x19
	.long	.LASF29
	.byte	0x8
	.value	0x116
	.long	.LASF30
	.long	0x2ca
	.long	0x420
	.uleb128 0x16
	.long	0x1181
	.byte	0
	.uleb128 0xe
	.long	0x2d5
	.uleb128 0x19
	.long	.LASF31
	.byte	0x8
	.value	0x11c
	.long	.LASF32
	.long	0x2d5
	.long	0x43f
	.uleb128 0x16
	.long	0x1168
	.byte	0
	.uleb128 0x19
	.long	.LASF33
	.byte	0x8
	.value	0x120
	.long	.LASF34
	.long	0x116e
	.long	0x45e
	.uleb128 0x16
	.long	0x1181
	.uleb128 0x16
	.long	0x1181
	.byte	0
	.uleb128 0x1a
	.string	"eof"
	.byte	0x8
	.value	0x124
	.long	.LASF259
	.long	0x2d5
	.uleb128 0x1b
	.long	.LASF35
	.byte	0x8
	.value	0x128
	.long	.LASF260
	.long	0x2d5
	.uleb128 0x16
	.long	0x1181
	.byte	0
	.byte	0
	.uleb128 0x3
	.long	.LASF2
	.byte	0x9
	.byte	0xba
	.long	0x5c
	.uleb128 0x11
	.byte	0xa
	.byte	0x35
	.long	0x1187
	.uleb128 0x11
	.byte	0xa
	.byte	0x36
	.long	0x12b4
	.uleb128 0x11
	.byte	0xa
	.byte	0x37
	.long	0x12ce
	.uleb128 0x3
	.long	.LASF36
	.byte	0x9
	.byte	0xbb
	.long	0xca
	.uleb128 0x1c
	.long	.LASF56
	.byte	0x4
	.byte	0xb
	.byte	0x33
	.long	0x53f
	.uleb128 0x1d
	.long	.LASF37
	.sleb128 1
	.uleb128 0x1d
	.long	.LASF38
	.sleb128 2
	.uleb128 0x1d
	.long	.LASF39
	.sleb128 4
	.uleb128 0x1d
	.long	.LASF40
	.sleb128 8
	.uleb128 0x1d
	.long	.LASF41
	.sleb128 16
	.uleb128 0x1d
	.long	.LASF42
	.sleb128 32
	.uleb128 0x1d
	.long	.LASF43
	.sleb128 64
	.uleb128 0x1d
	.long	.LASF44
	.sleb128 128
	.uleb128 0x1d
	.long	.LASF45
	.sleb128 256
	.uleb128 0x1d
	.long	.LASF46
	.sleb128 512
	.uleb128 0x1d
	.long	.LASF47
	.sleb128 1024
	.uleb128 0x1d
	.long	.LASF48
	.sleb128 2048
	.uleb128 0x1d
	.long	.LASF49
	.sleb128 4096
	.uleb128 0x1d
	.long	.LASF50
	.sleb128 8192
	.uleb128 0x1d
	.long	.LASF51
	.sleb128 16384
	.uleb128 0x1d
	.long	.LASF52
	.sleb128 176
	.uleb128 0x1d
	.long	.LASF53
	.sleb128 74
	.uleb128 0x1d
	.long	.LASF54
	.sleb128 260
	.uleb128 0x1d
	.long	.LASF55
	.sleb128 65536
	.byte	0
	.uleb128 0x1c
	.long	.LASF57
	.byte	0x4
	.byte	0xb
	.byte	0x67
	.long	0x578
	.uleb128 0x1d
	.long	.LASF58
	.sleb128 1
	.uleb128 0x1d
	.long	.LASF59
	.sleb128 2
	.uleb128 0x1d
	.long	.LASF60
	.sleb128 4
	.uleb128 0x1d
	.long	.LASF61
	.sleb128 8
	.uleb128 0x1d
	.long	.LASF62
	.sleb128 16
	.uleb128 0x1d
	.long	.LASF63
	.sleb128 32
	.uleb128 0x1d
	.long	.LASF64
	.sleb128 65536
	.byte	0
	.uleb128 0x1c
	.long	.LASF65
	.byte	0x4
	.byte	0xb
	.byte	0x8f
	.long	0x5a5
	.uleb128 0x1d
	.long	.LASF66
	.sleb128 0
	.uleb128 0x1d
	.long	.LASF67
	.sleb128 1
	.uleb128 0x1d
	.long	.LASF68
	.sleb128 2
	.uleb128 0x1d
	.long	.LASF69
	.sleb128 4
	.uleb128 0x1d
	.long	.LASF70
	.sleb128 65536
	.byte	0
	.uleb128 0x1c
	.long	.LASF71
	.byte	0x4
	.byte	0xb
	.byte	0xb5
	.long	0x5cc
	.uleb128 0x1d
	.long	.LASF72
	.sleb128 0
	.uleb128 0x1d
	.long	.LASF73
	.sleb128 1
	.uleb128 0x1d
	.long	.LASF74
	.sleb128 2
	.uleb128 0x1d
	.long	.LASF75
	.sleb128 65536
	.byte	0
	.uleb128 0x1e
	.long	.LASF103
	.long	0x7d8
	.uleb128 0x1f
	.long	.LASF78
	.byte	0x1
	.byte	0xb
	.value	0x215
	.byte	0x1
	.long	0x62b
	.uleb128 0x20
	.long	.LASF76
	.byte	0xb
	.value	0x21d
	.long	0x12ec
	.uleb128 0x20
	.long	.LASF77
	.byte	0xb
	.value	0x21e
	.long	0x116e
	.uleb128 0x21
	.long	.LASF78
	.byte	0xb
	.value	0x219
	.byte	0x1
	.long	0x60c
	.long	0x612
	.uleb128 0x22
	.long	0x1307
	.byte	0
	.uleb128 0x23
	.long	.LASF79
	.byte	0xb
	.value	0x21a
	.byte	0x1
	.long	0x61f
	.uleb128 0x22
	.long	0x1307
	.uleb128 0x22
	.long	0xca
	.byte	0
	.byte	0
	.uleb128 0x24
	.long	.LASF95
	.byte	0xb
	.byte	0xff
	.long	0x4b0
	.byte	0x1
	.uleb128 0x25
	.long	.LASF80
	.byte	0xb
	.value	0x102
	.long	0x645
	.byte	0x1
	.byte	0x1
	.uleb128 0xe
	.long	0x62b
	.uleb128 0x26
	.string	"dec"
	.byte	0xb
	.value	0x105
	.long	0x645
	.byte	0x1
	.byte	0x2
	.uleb128 0x25
	.long	.LASF81
	.byte	0xb
	.value	0x108
	.long	0x645
	.byte	0x1
	.byte	0x4
	.uleb128 0x26
	.string	"hex"
	.byte	0xb
	.value	0x10b
	.long	0x645
	.byte	0x1
	.byte	0x8
	.uleb128 0x25
	.long	.LASF82
	.byte	0xb
	.value	0x110
	.long	0x645
	.byte	0x1
	.byte	0x10
	.uleb128 0x25
	.long	.LASF83
	.byte	0xb
	.value	0x114
	.long	0x645
	.byte	0x1
	.byte	0x20
	.uleb128 0x26
	.string	"oct"
	.byte	0xb
	.value	0x117
	.long	0x645
	.byte	0x1
	.byte	0x40
	.uleb128 0x25
	.long	.LASF84
	.byte	0xb
	.value	0x11b
	.long	0x645
	.byte	0x1
	.byte	0x80
	.uleb128 0x27
	.long	.LASF85
	.byte	0xb
	.value	0x11e
	.long	0x645
	.byte	0x1
	.value	0x100
	.uleb128 0x27
	.long	.LASF86
	.byte	0xb
	.value	0x122
	.long	0x645
	.byte	0x1
	.value	0x200
	.uleb128 0x27
	.long	.LASF87
	.byte	0xb
	.value	0x126
	.long	0x645
	.byte	0x1
	.value	0x400
	.uleb128 0x27
	.long	.LASF88
	.byte	0xb
	.value	0x129
	.long	0x645
	.byte	0x1
	.value	0x800
	.uleb128 0x27
	.long	.LASF89
	.byte	0xb
	.value	0x12c
	.long	0x645
	.byte	0x1
	.value	0x1000
	.uleb128 0x27
	.long	.LASF90
	.byte	0xb
	.value	0x12f
	.long	0x645
	.byte	0x1
	.value	0x2000
	.uleb128 0x27
	.long	.LASF91
	.byte	0xb
	.value	0x133
	.long	0x645
	.byte	0x1
	.value	0x4000
	.uleb128 0x25
	.long	.LASF92
	.byte	0xb
	.value	0x136
	.long	0x645
	.byte	0x1
	.byte	0xb0
	.uleb128 0x25
	.long	.LASF93
	.byte	0xb
	.value	0x139
	.long	0x645
	.byte	0x1
	.byte	0x4a
	.uleb128 0x27
	.long	.LASF94
	.byte	0xb
	.value	0x13c
	.long	0x645
	.byte	0x1
	.value	0x104
	.uleb128 0x28
	.long	.LASF96
	.byte	0xb
	.value	0x14a
	.long	0x578
	.byte	0x1
	.uleb128 0x25
	.long	.LASF97
	.byte	0xb
	.value	0x14e
	.long	0x75b
	.byte	0x1
	.byte	0x1
	.uleb128 0xe
	.long	0x740
	.uleb128 0x25
	.long	.LASF98
	.byte	0xb
	.value	0x151
	.long	0x75b
	.byte	0x1
	.byte	0x2
	.uleb128 0x25
	.long	.LASF99
	.byte	0xb
	.value	0x156
	.long	0x75b
	.byte	0x1
	.byte	0x4
	.uleb128 0x25
	.long	.LASF100
	.byte	0xb
	.value	0x159
	.long	0x75b
	.byte	0x1
	.byte	0
	.uleb128 0x28
	.long	.LASF101
	.byte	0xb
	.value	0x169
	.long	0x53f
	.byte	0x1
	.uleb128 0x26
	.string	"in"
	.byte	0xb
	.value	0x177
	.long	0x7a4
	.byte	0x1
	.byte	0x8
	.uleb128 0xe
	.long	0x78a
	.uleb128 0x26
	.string	"out"
	.byte	0xb
	.value	0x17a
	.long	0x7a4
	.byte	0x1
	.byte	0x10
	.uleb128 0x28
	.long	.LASF102
	.byte	0xb
	.value	0x189
	.long	0x5a5
	.byte	0x1
	.uleb128 0x26
	.string	"cur"
	.byte	0xb
	.value	0x18f
	.long	0x7d2
	.byte	0x1
	.byte	0x1
	.uleb128 0xe
	.long	0x7b7
	.byte	0
	.uleb128 0x11
	.byte	0xc
	.byte	0x52
	.long	0x1318
	.uleb128 0x11
	.byte	0xc
	.byte	0x53
	.long	0x130d
	.uleb128 0x11
	.byte	0xc
	.byte	0x54
	.long	0x63
	.uleb128 0x11
	.byte	0xc
	.byte	0x5c
	.long	0x132e
	.uleb128 0x11
	.byte	0xc
	.byte	0x65
	.long	0x1348
	.uleb128 0x11
	.byte	0xc
	.byte	0x68
	.long	0x1362
	.uleb128 0x11
	.byte	0xc
	.byte	0x69
	.long	0x1377
	.uleb128 0x1e
	.long	.LASF104
	.long	0x825
	.uleb128 0x29
	.long	.LASF105
	.long	0x4a
	.uleb128 0x29
	.long	.LASF106
	.long	0x2be
	.byte	0
	.uleb128 0x3
	.long	.LASF107
	.byte	0xd
	.byte	0x88
	.long	0x809
	.uleb128 0x2a
	.long	.LASF261
	.byte	0x2
	.byte	0x3d
	.long	.LASF262
	.long	0x825
	.uleb128 0x2b
	.long	.LASF237
	.byte	0x2
	.byte	0x4a
	.long	0x5d5
	.byte	0
	.uleb128 0x2c
	.long	.LASF108
	.byte	0x6
	.value	0x161
	.long	0x63
	.long	0x861
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x2c
	.long	.LASF109
	.byte	0x6
	.value	0x2e9
	.long	0x63
	.long	0x877
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x2a
	.uleb128 0x2c
	.long	.LASF110
	.byte	0x6
	.value	0x306
	.long	0x89d
	.long	0x89d
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0xca
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x8a3
	.uleb128 0x5
	.byte	0x4
	.byte	0x5
	.long	.LASF111
	.uleb128 0x2c
	.long	.LASF112
	.byte	0x6
	.value	0x2f7
	.long	0x63
	.long	0x8c5
	.uleb128 0x16
	.long	0x8a3
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0x2c
	.long	.LASF113
	.byte	0x6
	.value	0x30d
	.long	0xca
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x8e6
	.uleb128 0xe
	.long	0x8a3
	.uleb128 0x2c
	.long	.LASF114
	.byte	0x6
	.value	0x24b
	.long	0xca
	.long	0x906
	.uleb128 0x16
	.long	0x877
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x2c
	.long	.LASF115
	.byte	0x6
	.value	0x252
	.long	0xca
	.long	0x922
	.uleb128 0x16
	.long	0x877
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x2c
	.long	.LASF116
	.byte	0x6
	.value	0x27b
	.long	0xca
	.long	0x93e
	.uleb128 0x16
	.long	0x877
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x2c
	.long	.LASF117
	.byte	0x6
	.value	0x2ea
	.long	0x63
	.long	0x954
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0x2e
	.long	.LASF227
	.byte	0x6
	.value	0x2f0
	.long	0x63
	.uleb128 0x2c
	.long	.LASF118
	.byte	0x6
	.value	0x178
	.long	0x51
	.long	0x980
	.uleb128 0x16
	.long	0xf3
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x980
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0xdc
	.uleb128 0x2c
	.long	.LASF119
	.byte	0x6
	.value	0x16d
	.long	0x51
	.long	0x9ab
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0xf3
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x980
	.byte	0
	.uleb128 0x2c
	.long	.LASF120
	.byte	0x6
	.value	0x169
	.long	0xca
	.long	0x9c1
	.uleb128 0x16
	.long	0x9c1
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x9c7
	.uleb128 0xe
	.long	0xdc
	.uleb128 0x2c
	.long	.LASF121
	.byte	0x6
	.value	0x198
	.long	0x51
	.long	0x9f1
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x9f1
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x980
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0xf3
	.uleb128 0x2c
	.long	.LASF122
	.byte	0x6
	.value	0x2f8
	.long	0x63
	.long	0xa12
	.uleb128 0x16
	.long	0x8a3
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0x2c
	.long	.LASF123
	.byte	0x6
	.value	0x2fe
	.long	0x63
	.long	0xa28
	.uleb128 0x16
	.long	0x8a3
	.byte	0
	.uleb128 0x2c
	.long	.LASF124
	.byte	0x6
	.value	0x25c
	.long	0xca
	.long	0xa49
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x2c
	.long	.LASF125
	.byte	0x6
	.value	0x285
	.long	0xca
	.long	0xa65
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x2c
	.long	.LASF126
	.byte	0x6
	.value	0x315
	.long	0x63
	.long	0xa80
	.uleb128 0x16
	.long	0x63
	.uleb128 0x16
	.long	0x877
	.byte	0
	.uleb128 0x2c
	.long	.LASF127
	.byte	0x6
	.value	0x264
	.long	0xca
	.long	0xaa0
	.uleb128 0x16
	.long	0x877
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF128
	.byte	0x6
	.value	0x2b1
	.long	0xca
	.long	0xac0
	.uleb128 0x16
	.long	0x877
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF129
	.byte	0x6
	.value	0x271
	.long	0xca
	.long	0xae5
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF130
	.byte	0x6
	.value	0x2bd
	.long	0xca
	.long	0xb05
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF131
	.byte	0x6
	.value	0x26c
	.long	0xca
	.long	0xb20
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF132
	.byte	0x6
	.value	0x2b9
	.long	0xca
	.long	0xb3b
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x35
	.byte	0
	.uleb128 0x2c
	.long	.LASF133
	.byte	0x6
	.value	0x172
	.long	0x51
	.long	0xb5b
	.uleb128 0x16
	.long	0xb5b
	.uleb128 0x16
	.long	0x8a3
	.uleb128 0x16
	.long	0x980
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x4a
	.uleb128 0x2f
	.long	.LASF134
	.byte	0x6
	.byte	0x9b
	.long	0x89d
	.long	0xb7b
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2f
	.long	.LASF135
	.byte	0x6
	.byte	0xa3
	.long	0xca
	.long	0xb95
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2f
	.long	.LASF136
	.byte	0x6
	.byte	0xc0
	.long	0xca
	.long	0xbaf
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2f
	.long	.LASF137
	.byte	0x6
	.byte	0x93
	.long	0x89d
	.long	0xbc9
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2f
	.long	.LASF138
	.byte	0x6
	.byte	0xfc
	.long	0x51
	.long	0xbe3
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2c
	.long	.LASF139
	.byte	0x6
	.value	0x357
	.long	0x51
	.long	0xc08
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xc08
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0xc0e
	.uleb128 0xe
	.long	0xc13
	.uleb128 0x30
	.string	"tm"
	.byte	0x2c
	.byte	0xe
	.byte	0x85
	.long	0xca3
	.uleb128 0xa
	.long	.LASF141
	.byte	0xe
	.byte	0x87
	.long	0xca
	.byte	0
	.uleb128 0xa
	.long	.LASF142
	.byte	0xe
	.byte	0x88
	.long	0xca
	.byte	0x4
	.uleb128 0xa
	.long	.LASF143
	.byte	0xe
	.byte	0x89
	.long	0xca
	.byte	0x8
	.uleb128 0xa
	.long	.LASF144
	.byte	0xe
	.byte	0x8a
	.long	0xca
	.byte	0xc
	.uleb128 0xa
	.long	.LASF145
	.byte	0xe
	.byte	0x8b
	.long	0xca
	.byte	0x10
	.uleb128 0xa
	.long	.LASF146
	.byte	0xe
	.byte	0x8c
	.long	0xca
	.byte	0x14
	.uleb128 0xa
	.long	.LASF147
	.byte	0xe
	.byte	0x8d
	.long	0xca
	.byte	0x18
	.uleb128 0xa
	.long	.LASF148
	.byte	0xe
	.byte	0x8e
	.long	0xca
	.byte	0x1c
	.uleb128 0xa
	.long	.LASF149
	.byte	0xe
	.byte	0x8f
	.long	0xca
	.byte	0x20
	.uleb128 0xa
	.long	.LASF150
	.byte	0xe
	.byte	0x92
	.long	0xde6
	.byte	0x24
	.uleb128 0xa
	.long	.LASF151
	.byte	0xe
	.byte	0x93
	.long	0xf3
	.byte	0x28
	.byte	0
	.uleb128 0x2c
	.long	.LASF152
	.byte	0x6
	.value	0x11f
	.long	0x51
	.long	0xcb9
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2f
	.long	.LASF153
	.byte	0x6
	.byte	0x9e
	.long	0x89d
	.long	0xcd8
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2f
	.long	.LASF154
	.byte	0x6
	.byte	0xa6
	.long	0xca
	.long	0xcf7
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2f
	.long	.LASF155
	.byte	0x6
	.byte	0x96
	.long	0x89d
	.long	0xd16
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF156
	.byte	0x6
	.value	0x19e
	.long	0x51
	.long	0xd3b
	.uleb128 0x16
	.long	0xb5b
	.uleb128 0x16
	.long	0xd3b
	.uleb128 0x16
	.long	0x51
	.uleb128 0x16
	.long	0x980
	.byte	0
	.uleb128 0xf
	.byte	0x4
	.long	0x8e0
	.uleb128 0x2c
	.long	.LASF157
	.byte	0x6
	.value	0x100
	.long	0x51
	.long	0xd5c
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x2c
	.long	.LASF158
	.byte	0x6
	.value	0x1c2
	.long	0xd77
	.long	0xd77
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.byte	0
	.uleb128 0x5
	.byte	0x8
	.byte	0x4
	.long	.LASF159
	.uleb128 0xf
	.byte	0x4
	.long	0x89d
	.uleb128 0x2c
	.long	.LASF160
	.byte	0x6
	.value	0x1c9
	.long	0xd9f
	.long	0xd9f
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.byte	0
	.uleb128 0x5
	.byte	0x4
	.byte	0x4
	.long	.LASF161
	.uleb128 0x2c
	.long	.LASF162
	.byte	0x6
	.value	0x11a
	.long	0x89d
	.long	0xdc6
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.byte	0
	.uleb128 0x2c
	.long	.LASF163
	.byte	0x6
	.value	0x1d4
	.long	0xde6
	.long	0xde6
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x5
	.byte	0x4
	.byte	0x5
	.long	.LASF164
	.uleb128 0x2c
	.long	.LASF165
	.byte	0x6
	.value	0x1d9
	.long	0xe0d
	.long	0xe0d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x5
	.byte	0x4
	.byte	0x7
	.long	.LASF166
	.uleb128 0x2f
	.long	.LASF167
	.byte	0x6
	.byte	0xc4
	.long	0x51
	.long	0xe33
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF168
	.byte	0x6
	.value	0x165
	.long	0xca
	.long	0xe49
	.uleb128 0x16
	.long	0x63
	.byte	0
	.uleb128 0x2c
	.long	.LASF169
	.byte	0x6
	.value	0x145
	.long	0xca
	.long	0xe69
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF170
	.byte	0x6
	.value	0x149
	.long	0x89d
	.long	0xe89
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF171
	.byte	0x6
	.value	0x14e
	.long	0x89d
	.long	0xea9
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF172
	.byte	0x6
	.value	0x152
	.long	0x89d
	.long	0xec9
	.uleb128 0x16
	.long	0x89d
	.uleb128 0x16
	.long	0x8a3
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x2c
	.long	.LASF173
	.byte	0x6
	.value	0x259
	.long	0xca
	.long	0xee0
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x2c
	.long	.LASF174
	.byte	0x6
	.value	0x282
	.long	0xca
	.long	0xef7
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x2d
	.byte	0
	.uleb128 0x18
	.long	.LASF175
	.byte	0x6
	.byte	0xe0
	.long	.LASF175
	.long	0x8e0
	.long	0xf15
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8a3
	.byte	0
	.uleb128 0x19
	.long	.LASF177
	.byte	0x6
	.value	0x106
	.long	.LASF177
	.long	0x8e0
	.long	0xf34
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x18
	.long	.LASF178
	.byte	0x6
	.byte	0xea
	.long	.LASF178
	.long	0x8e0
	.long	0xf52
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8a3
	.byte	0
	.uleb128 0x19
	.long	.LASF179
	.byte	0x6
	.value	0x111
	.long	.LASF179
	.long	0x8e0
	.long	0xf71
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8e0
	.byte	0
	.uleb128 0x19
	.long	.LASF180
	.byte	0x6
	.value	0x13c
	.long	.LASF180
	.long	0x8e0
	.long	0xf95
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0x8a3
	.uleb128 0x16
	.long	0x51
	.byte	0
	.uleb128 0x31
	.long	.LASF181
	.byte	0x7
	.byte	0xf2
	.long	0x10ca
	.uleb128 0x11
	.byte	0x7
	.byte	0xf8
	.long	0x10ca
	.uleb128 0x12
	.byte	0x7
	.value	0x101
	.long	0x10ec
	.uleb128 0x12
	.byte	0x7
	.value	0x102
	.long	0x1113
	.uleb128 0x11
	.byte	0xf
	.byte	0x2c
	.long	0x485
	.uleb128 0x11
	.byte	0xf
	.byte	0x2d
	.long	0x4a5
	.uleb128 0x14
	.long	.LASF182
	.byte	0x1
	.byte	0x10
	.byte	0x37
	.long	0x1007
	.uleb128 0x32
	.long	.LASF183
	.byte	0x10
	.byte	0x3a
	.long	0xee
	.uleb128 0x32
	.long	.LASF184
	.byte	0x10
	.byte	0x3b
	.long	0xee
	.uleb128 0x32
	.long	.LASF185
	.byte	0x10
	.byte	0x3f
	.long	0x12f7
	.uleb128 0x32
	.long	.LASF186
	.byte	0x10
	.byte	0x40
	.long	0xee
	.uleb128 0x29
	.long	.LASF187
	.long	0xca
	.byte	0
	.uleb128 0x14
	.long	.LASF188
	.byte	0x1
	.byte	0x10
	.byte	0x37
	.long	0x1049
	.uleb128 0x32
	.long	.LASF183
	.byte	0x10
	.byte	0x3a
	.long	0x1302
	.uleb128 0x32
	.long	.LASF184
	.byte	0x10
	.byte	0x3b
	.long	0x1302
	.uleb128 0x32
	.long	.LASF185
	.byte	0x10
	.byte	0x3f
	.long	0x12f7
	.uleb128 0x32
	.long	.LASF186
	.byte	0x10
	.byte	0x40
	.long	0xee
	.uleb128 0x29
	.long	.LASF187
	.long	0xe0d
	.byte	0
	.uleb128 0x14
	.long	.LASF189
	.byte	0x1
	.byte	0x10
	.byte	0x37
	.long	0x108b
	.uleb128 0x32
	.long	.LASF183
	.byte	0x10
	.byte	0x3a
	.long	0xf9
	.uleb128 0x32
	.long	.LASF184
	.byte	0x10
	.byte	0x3b
	.long	0xf9
	.uleb128 0x32
	.long	.LASF185
	.byte	0x10
	.byte	0x3f
	.long	0x12f7
	.uleb128 0x32
	.long	.LASF186
	.byte	0x10
	.byte	0x40
	.long	0xee
	.uleb128 0x29
	.long	.LASF187
	.long	0x4a
	.byte	0
	.uleb128 0x33
	.long	.LASF263
	.byte	0x1
	.byte	0x10
	.byte	0x37
	.uleb128 0x32
	.long	.LASF183
	.byte	0x10
	.byte	0x3a
	.long	0x138c
	.uleb128 0x32
	.long	.LASF184
	.byte	0x10
	.byte	0x3b
	.long	0x138c
	.uleb128 0x32
	.long	.LASF185
	.byte	0x10
	.byte	0x3f
	.long	0x12f7
	.uleb128 0x32
	.long	.LASF186
	.byte	0x10
	.byte	0x40
	.long	0xee
	.uleb128 0x29
	.long	.LASF187
	.long	0x1148
	.byte	0
	.byte	0
	.uleb128 0x2c
	.long	.LASF190
	.byte	0x6
	.value	0x1cb
	.long	0x10e5
	.long	0x10e5
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.byte	0
	.uleb128 0x5
	.byte	0xc
	.byte	0x4
	.long	.LASF191
	.uleb128 0x2c
	.long	.LASF192
	.byte	0x6
	.value	0x1e3
	.long	0x110c
	.long	0x110c
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x5
	.byte	0x8
	.byte	0x5
	.long	.LASF193
	.uleb128 0x2c
	.long	.LASF194
	.byte	0x6
	.value	0x1ea
	.long	0x1133
	.long	0x1133
	.uleb128 0x16
	.long	0x8e0
	.uleb128 0x16
	.long	0xd7e
	.uleb128 0x16
	.long	0xca
	.byte	0
	.uleb128 0x5
	.byte	0x8
	.byte	0x7
	.long	.LASF195
	.uleb128 0x5
	.byte	0x1
	.byte	0x8
	.long	.LASF196
	.uleb128 0x5
	.byte	0x1
	.byte	0x6
	.long	.LASF197
	.uleb128 0x5
	.byte	0x2
	.byte	0x5
	.long	.LASF198
	.uleb128 0x31
	.long	.LASF199
	.byte	0x11
	.byte	0x37
	.long	0x1162
	.uleb128 0x34
	.byte	0x11
	.byte	0x38
	.long	0x2b7
	.byte	0
	.uleb128 0x35
	.byte	0x4
	.long	0x2ca
	.uleb128 0x35
	.byte	0x4
	.long	0x2fa
	.uleb128 0x5
	.byte	0x1
	.byte	0x2
	.long	.LASF200
	.uleb128 0xf
	.byte	0x4
	.long	0x2fa
	.uleb128 0xf
	.byte	0x4
	.long	0x2ca
	.uleb128 0x35
	.byte	0x4
	.long	0x420
	.uleb128 0x14
	.long	.LASF201
	.byte	0x38
	.byte	0x12
	.byte	0x35
	.long	0x12b4
	.uleb128 0xa
	.long	.LASF202
	.byte	0x12
	.byte	0x39
	.long	0xb5b
	.byte	0
	.uleb128 0xa
	.long	.LASF203
	.byte	0x12
	.byte	0x3a
	.long	0xb5b
	.byte	0x4
	.uleb128 0xa
	.long	.LASF204
	.byte	0x12
	.byte	0x40
	.long	0xb5b
	.byte	0x8
	.uleb128 0xa
	.long	.LASF205
	.byte	0x12
	.byte	0x46
	.long	0xb5b
	.byte	0xc
	.uleb128 0xa
	.long	.LASF206
	.byte	0x12
	.byte	0x47
	.long	0xb5b
	.byte	0x10
	.uleb128 0xa
	.long	.LASF207
	.byte	0x12
	.byte	0x48
	.long	0xb5b
	.byte	0x14
	.uleb128 0xa
	.long	.LASF208
	.byte	0x12
	.byte	0x49
	.long	0xb5b
	.byte	0x18
	.uleb128 0xa
	.long	.LASF209
	.byte	0x12
	.byte	0x4a
	.long	0xb5b
	.byte	0x1c
	.uleb128 0xa
	.long	.LASF210
	.byte	0x12
	.byte	0x4b
	.long	0xb5b
	.byte	0x20
	.uleb128 0xa
	.long	.LASF211
	.byte	0x12
	.byte	0x4c
	.long	0xb5b
	.byte	0x24
	.uleb128 0xa
	.long	.LASF212
	.byte	0x12
	.byte	0x4d
	.long	0x4a
	.byte	0x28
	.uleb128 0xa
	.long	.LASF213
	.byte	0x12
	.byte	0x4e
	.long	0x4a
	.byte	0x29
	.uleb128 0xa
	.long	.LASF214
	.byte	0x12
	.byte	0x50
	.long	0x4a
	.byte	0x2a
	.uleb128 0xa
	.long	.LASF215
	.byte	0x12
	.byte	0x52
	.long	0x4a
	.byte	0x2b
	.uleb128 0xa
	.long	.LASF216
	.byte	0x12
	.byte	0x54
	.long	0x4a
	.byte	0x2c
	.uleb128 0xa
	.long	.LASF217
	.byte	0x12
	.byte	0x56
	.long	0x4a
	.byte	0x2d
	.uleb128 0xa
	.long	.LASF218
	.byte	0x12
	.byte	0x5d
	.long	0x4a
	.byte	0x2e
	.uleb128 0xa
	.long	.LASF219
	.byte	0x12
	.byte	0x5e
	.long	0x4a
	.byte	0x2f
	.uleb128 0xa
	.long	.LASF220
	.byte	0x12
	.byte	0x61
	.long	0x4a
	.byte	0x30
	.uleb128 0xa
	.long	.LASF221
	.byte	0x12
	.byte	0x63
	.long	0x4a
	.byte	0x31
	.uleb128 0xa
	.long	.LASF222
	.byte	0x12
	.byte	0x65
	.long	0x4a
	.byte	0x32
	.uleb128 0xa
	.long	.LASF223
	.byte	0x12
	.byte	0x67
	.long	0x4a
	.byte	0x33
	.uleb128 0xa
	.long	.LASF224
	.byte	0x12
	.byte	0x6e
	.long	0x4a
	.byte	0x34
	.uleb128 0xa
	.long	.LASF225
	.byte	0x12
	.byte	0x6f
	.long	0x4a
	.byte	0x35
	.byte	0
	.uleb128 0x2f
	.long	.LASF226
	.byte	0x12
	.byte	0x7c
	.long	0xb5b
	.long	0x12ce
	.uleb128 0x16
	.long	0xca
	.uleb128 0x16
	.long	0xf3
	.byte	0
	.uleb128 0x36
	.long	.LASF228
	.byte	0x12
	.byte	0x7f
	.long	0x12d9
	.uleb128 0xf
	.byte	0x4
	.long	0x1187
	.uleb128 0x3
	.long	.LASF229
	.byte	0x13
	.byte	0x28
	.long	0xca
	.uleb128 0x37
	.byte	0x4
	.uleb128 0x3
	.long	.LASF230
	.byte	0x14
	.byte	0x20
	.long	0xca
	.uleb128 0xe
	.long	0x116e
	.uleb128 0xf
	.byte	0x4
	.long	0xb5b
	.uleb128 0xe
	.long	0xe0d
	.uleb128 0xf
	.byte	0x4
	.long	0x5d5
	.uleb128 0x3
	.long	.LASF231
	.byte	0x15
	.byte	0x34
	.long	0xe0d
	.uleb128 0x3
	.long	.LASF232
	.byte	0x15
	.byte	0xba
	.long	0x1323
	.uleb128 0xf
	.byte	0x4
	.long	0x1329
	.uleb128 0xe
	.long	0x12df
	.uleb128 0x2f
	.long	.LASF233
	.byte	0x15
	.byte	0xaf
	.long	0xca
	.long	0x1348
	.uleb128 0x16
	.long	0x63
	.uleb128 0x16
	.long	0x130d
	.byte	0
	.uleb128 0x2f
	.long	.LASF234
	.byte	0x15
	.byte	0xdd
	.long	0x63
	.long	0x1362
	.uleb128 0x16
	.long	0x63
	.uleb128 0x16
	.long	0x1318
	.byte	0
	.uleb128 0x2f
	.long	.LASF235
	.byte	0x15
	.byte	0xda
	.long	0x1318
	.long	0x1377
	.uleb128 0x16
	.long	0xf3
	.byte	0
	.uleb128 0x2f
	.long	.LASF236
	.byte	0x15
	.byte	0xab
	.long	0x130d
	.long	0x138c
	.uleb128 0x16
	.long	0xf3
	.byte	0
	.uleb128 0xe
	.long	0x1148
	.uleb128 0x34
	.byte	0x1
	.byte	0x3
	.long	0xfe
	.uleb128 0x38
	.long	.LASF238
	.byte	0x1
	.byte	0x5
	.long	.LASF264
	.long	.LFB971
	.long	.LFE971-.LFB971
	.uleb128 0x1
	.byte	0x9c
	.long	0x13c8
	.uleb128 0x39
	.long	.LBB2
	.long	.LBE2-.LBB2
	.uleb128 0x3a
	.string	"i"
	.byte	0x1
	.byte	0x6
	.long	0xca
	.uleb128 0x2
	.byte	0x91
	.sleb128 -20
	.byte	0
	.byte	0
	.uleb128 0x3b
	.long	.LASF239
	.byte	0x1
	.byte	0xc
	.long	0xca
	.long	.LFB972
	.long	.LFE972-.LFB972
	.uleb128 0x1
	.byte	0x9c
	.long	0x1414
	.uleb128 0x3c
	.long	.LASF240
	.byte	0x1
	.byte	0xc
	.long	0xca
	.uleb128 0x2
	.byte	0x91
	.sleb128 0
	.uleb128 0x3c
	.long	.LASF241
	.byte	0x1
	.byte	0xc
	.long	0x12fc
	.uleb128 0x2
	.byte	0x91
	.sleb128 4
	.uleb128 0x39
	.long	.LBB3
	.long	.LBE3-.LBB3
	.uleb128 0x3a
	.string	"i"
	.byte	0x1
	.byte	0xd
	.long	0xca
	.uleb128 0x2
	.byte	0x74
	.sleb128 28
	.byte	0
	.byte	0
	.uleb128 0x3d
	.long	.LASF265
	.long	.LFB978
	.long	.LFE978-.LFB978
	.uleb128 0x1
	.byte	0x9c
	.long	0x1444
	.uleb128 0x3c
	.long	.LASF242
	.byte	0x1
	.byte	0x11
	.long	0xca
	.uleb128 0x2
	.byte	0x91
	.sleb128 0
	.uleb128 0x3c
	.long	.LASF243
	.byte	0x1
	.byte	0x11
	.long	0xca
	.uleb128 0x2
	.byte	0x91
	.sleb128 4
	.byte	0
	.uleb128 0x3e
	.long	.LASF266
	.long	.LFB979
	.long	.LFE979-.LFB979
	.uleb128 0x1
	.byte	0x9c
	.uleb128 0x3f
	.long	.LASF244
	.long	0x12ea
	.uleb128 0x40
	.long	0x83f
	.uleb128 0x5
	.byte	0x3
	.long	_ZStL8__ioinit
	.uleb128 0x41
	.long	0xfd1
	.long	.LASF245
	.sleb128 -2147483648
	.uleb128 0x42
	.long	0xfdc
	.long	.LASF246
	.long	0x7fffffff
	.uleb128 0x43
	.long	0x1034
	.long	.LASF247
	.byte	0x20
	.uleb128 0x43
	.long	0x1060
	.long	.LASF248
	.byte	0x7f
	.uleb128 0x41
	.long	0x1093
	.long	.LASF249
	.sleb128 -32768
	.uleb128 0x44
	.long	0x109e
	.long	.LASF250
	.value	0x7fff
	.byte	0
	.section	.debug_abbrev,"",@progbits
.Ldebug_abbrev0:
	.uleb128 0x1
	.uleb128 0x11
	.byte	0x1
	.uleb128 0x25
	.uleb128 0xe
	.uleb128 0x13
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x1b
	.uleb128 0xe
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x10
	.uleb128 0x17
	.byte	0
	.byte	0
	.uleb128 0x2
	.uleb128 0x13
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x3
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x4
	.uleb128 0xf
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x5
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0xe
	.byte	0
	.byte	0
	.uleb128 0x6
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x7
	.uleb128 0x13
	.byte	0x1
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x8
	.uleb128 0x17
	.byte	0x1
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x9
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xa
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x38
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xb
	.uleb128 0x1
	.byte	0x1
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xc
	.uleb128 0x21
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2f
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xd
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0x8
	.byte	0
	.byte	0
	.uleb128 0xe
	.uleb128 0x26
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xf
	.uleb128 0xf
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x10
	.uleb128 0x39
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x11
	.uleb128 0x8
	.byte	0
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x18
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x12
	.uleb128 0x8
	.byte	0
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x18
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x13
	.uleb128 0x39
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x14
	.uleb128 0x13
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x15
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x16
	.uleb128 0x5
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x17
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x18
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x19
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x1a
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x1b
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x1c
	.uleb128 0x4
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x1d
	.uleb128 0x28
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x1c
	.uleb128 0xd
	.byte	0
	.byte	0
	.uleb128 0x1e
	.uleb128 0x2
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x1f
	.uleb128 0x2
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x20
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x21
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x64
	.uleb128 0x13
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x22
	.uleb128 0x5
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x34
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x23
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x64
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x24
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x32
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x25
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1c
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x26
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1c
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x27
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x32
	.uleb128 0xb
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1c
	.uleb128 0x5
	.byte	0
	.byte	0
	.uleb128 0x28
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x32
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x29
	.uleb128 0x2f
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x2a
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x2b
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x2c
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x2d
	.uleb128 0x18
	.byte	0
	.byte	0
	.byte	0
	.uleb128 0x2e
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x2f
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x30
	.uleb128 0x13
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x31
	.uleb128 0x39
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x32
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x33
	.uleb128 0x13
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x34
	.uleb128 0x3a
	.byte	0
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x18
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x35
	.uleb128 0x10
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x36
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x37
	.uleb128 0xf
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x38
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x39
	.uleb128 0xb
	.byte	0x1
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.byte	0
	.byte	0
	.uleb128 0x3a
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x3b
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x3c
	.uleb128 0x5
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x3d
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x34
	.uleb128 0x19
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x3e
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x34
	.uleb128 0x19
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x6
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x3f
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x34
	.uleb128 0x19
	.uleb128 0x3c
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x40
	.uleb128 0x34
	.byte	0
	.uleb128 0x47
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x41
	.uleb128 0x34
	.byte	0
	.uleb128 0x47
	.uleb128 0x13
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x1c
	.uleb128 0xd
	.byte	0
	.byte	0
	.uleb128 0x42
	.uleb128 0x34
	.byte	0
	.uleb128 0x47
	.uleb128 0x13
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x1c
	.uleb128 0x6
	.byte	0
	.byte	0
	.uleb128 0x43
	.uleb128 0x34
	.byte	0
	.uleb128 0x47
	.uleb128 0x13
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x1c
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x44
	.uleb128 0x34
	.byte	0
	.uleb128 0x47
	.uleb128 0x13
	.uleb128 0x6e
	.uleb128 0xe
	.uleb128 0x1c
	.uleb128 0x5
	.byte	0
	.byte	0
	.byte	0
	.section	.debug_aranges,"",@progbits
	.long	0x1c
	.value	0x2
	.long	.Ldebug_info0
	.byte	0x4
	.byte	0
	.value	0
	.value	0
	.long	.Ltext0
	.long	.Letext0-.Ltext0
	.long	0
	.long	0
	.section	.debug_line,"",@progbits
.Ldebug_line0:
	.section	.debug_str,"MS",@progbits,1
.LASF74:
	.string	"_S_end"
.LASF2:
	.string	"size_t"
.LASF10:
	.string	"sizetype"
.LASF143:
	.string	"tm_hour"
.LASF9:
	.string	"__value"
.LASF182:
	.string	"__numeric_traits_integer<int>"
.LASF246:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerIiE5__maxE"
.LASF80:
	.string	"boolalpha"
.LASF85:
	.string	"scientific"
.LASF184:
	.string	"__max"
.LASF138:
	.string	"wcscspn"
.LASF228:
	.string	"localeconv"
.LASF253:
	.string	"/home/dbondin/progs/c++examples/src/example-85"
.LASF213:
	.string	"frac_digits"
.LASF205:
	.string	"int_curr_symbol"
.LASF100:
	.string	"goodbit"
.LASF175:
	.string	"wcschr"
.LASF37:
	.string	"_S_boolalpha"
.LASF67:
	.string	"_S_badbit"
.LASF99:
	.string	"failbit"
.LASF216:
	.string	"n_cs_precedes"
.LASF119:
	.string	"mbrtowc"
.LASF167:
	.string	"wcsxfrm"
.LASF212:
	.string	"int_frac_digits"
.LASF72:
	.string	"_S_beg"
.LASF136:
	.string	"wcscoll"
.LASF89:
	.string	"skipws"
.LASF6:
	.string	"__wch"
.LASF91:
	.string	"uppercase"
.LASF53:
	.string	"_S_basefield"
.LASF32:
	.string	"_ZNSt11char_traitsIcE11to_int_typeERKc"
.LASF207:
	.string	"mon_decimal_point"
.LASF164:
	.string	"long int"
.LASF189:
	.string	"__numeric_traits_integer<char>"
.LASF131:
	.string	"vwprintf"
.LASF57:
	.string	"_Ios_Openmode"
.LASF238:
	.string	"test"
.LASF15:
	.string	"int_type"
.LASF239:
	.string	"main"
.LASF222:
	.string	"int_n_cs_precedes"
.LASF234:
	.string	"towctrans"
.LASF25:
	.string	"copy"
.LASF12:
	.string	"mbstate_t"
.LASF237:
	.string	"__ioinit"
.LASF77:
	.string	"_S_synced_with_stdio"
.LASF187:
	.string	"_Value"
.LASF68:
	.string	"_S_eofbit"
.LASF252:
	.string	"main.cpp"
.LASF148:
	.string	"tm_yday"
.LASF197:
	.string	"signed char"
.LASF254:
	.string	"_IO_FILE"
.LASF104:
	.string	"basic_ostream<char, std::char_traits<char> >"
.LASF231:
	.string	"wctype_t"
.LASF109:
	.string	"fgetwc"
.LASF227:
	.string	"getwchar"
.LASF110:
	.string	"fgetws"
.LASF44:
	.string	"_S_right"
.LASF14:
	.string	"char_type"
.LASF196:
	.string	"unsigned char"
.LASF217:
	.string	"n_sep_by_space"
.LASF180:
	.string	"wmemchr"
.LASF66:
	.string	"_S_goodbit"
.LASF250:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerIsE5__maxE"
.LASF60:
	.string	"_S_bin"
.LASF135:
	.string	"wcscmp"
.LASF255:
	.string	"__builtin_va_list"
.LASF35:
	.string	"not_eof"
.LASF124:
	.string	"swprintf"
.LASF1:
	.string	"__gnuc_va_list"
.LASF185:
	.string	"__is_signed"
.LASF62:
	.string	"_S_out"
.LASF3:
	.string	"char"
.LASF58:
	.string	"_S_app"
.LASF24:
	.string	"_ZNSt11char_traitsIcE4moveEPcPKcj"
.LASF101:
	.string	"openmode"
.LASF154:
	.string	"wcsncmp"
.LASF225:
	.string	"int_n_sign_posn"
.LASF219:
	.string	"n_sign_posn"
.LASF171:
	.string	"wmemmove"
.LASF183:
	.string	"__min"
.LASF108:
	.string	"btowc"
.LASF174:
	.string	"wscanf"
.LASF208:
	.string	"mon_thousands_sep"
.LASF126:
	.string	"ungetwc"
.LASF36:
	.string	"ptrdiff_t"
.LASF245:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerIiE5__minE"
.LASF232:
	.string	"wctrans_t"
.LASF118:
	.string	"mbrlen"
.LASF211:
	.string	"negative_sign"
.LASF40:
	.string	"_S_hex"
.LASF220:
	.string	"int_p_cs_precedes"
.LASF115:
	.string	"fwprintf"
.LASF261:
	.string	"cout"
.LASF194:
	.string	"wcstoull"
.LASF41:
	.string	"_S_internal"
.LASF18:
	.string	"compare"
.LASF144:
	.string	"tm_mday"
.LASF93:
	.string	"basefield"
.LASF20:
	.string	"find"
.LASF137:
	.string	"wcscpy"
.LASF105:
	.string	"_CharT"
.LASF81:
	.string	"fixed"
.LASF129:
	.string	"vswprintf"
.LASF172:
	.string	"wmemset"
.LASF102:
	.string	"seekdir"
.LASF114:
	.string	"fwide"
.LASF83:
	.string	"left"
.LASF264:
	.string	"_Z4testv"
.LASF141:
	.string	"tm_sec"
.LASF149:
	.string	"tm_isdst"
.LASF155:
	.string	"wcsncpy"
.LASF123:
	.string	"putwchar"
.LASF169:
	.string	"wmemcmp"
.LASF26:
	.string	"_ZNSt11char_traitsIcE4copyEPcPKcj"
.LASF17:
	.string	"_ZNSt11char_traitsIcE2ltERKcS2_"
.LASF39:
	.string	"_S_fixed"
.LASF223:
	.string	"int_n_sep_by_space"
.LASF243:
	.string	"__priority"
.LASF23:
	.string	"move"
.LASF46:
	.string	"_S_showbase"
.LASF61:
	.string	"_S_in"
.LASF266:
	.string	"_GLOBAL__sub_I__Z4testv"
.LASF199:
	.string	"__gnu_debug"
.LASF127:
	.string	"vfwprintf"
.LASF130:
	.string	"vswscanf"
.LASF215:
	.string	"p_sep_by_space"
.LASF33:
	.string	"eq_int_type"
.LASF240:
	.string	"argc"
.LASF76:
	.string	"_S_refcount"
.LASF251:
	.string	"GNU C++ 4.8.4 -mtune=generic -march=i686 -g -O0 -fstack-protector"
.LASF241:
	.string	"argv"
.LASF63:
	.string	"_S_trunc"
.LASF242:
	.string	"__initialize_p"
.LASF84:
	.string	"right"
.LASF48:
	.string	"_S_showpos"
.LASF11:
	.string	"__mbstate_t"
.LASF170:
	.string	"wmemcpy"
.LASF145:
	.string	"tm_mon"
.LASF38:
	.string	"_S_dec"
.LASF56:
	.string	"_Ios_Fmtflags"
.LASF159:
	.string	"double"
.LASF82:
	.string	"internal"
.LASF249:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerIsE5__minE"
.LASF168:
	.string	"wctob"
.LASF47:
	.string	"_S_showpoint"
.LASF49:
	.string	"_S_skipws"
.LASF52:
	.string	"_S_adjustfield"
.LASF28:
	.string	"_ZNSt11char_traitsIcE6assignEPcjc"
.LASF247:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerImE8__digitsE"
.LASF161:
	.string	"float"
.LASF262:
	.string	"_ZSt4cout"
.LASF142:
	.string	"tm_min"
.LASF42:
	.string	"_S_left"
.LASF4:
	.string	"unsigned int"
.LASF140:
	.string	"char_traits<char>"
.LASF210:
	.string	"positive_sign"
.LASF64:
	.string	"_S_ios_openmode_end"
.LASF157:
	.string	"wcsspn"
.LASF218:
	.string	"p_sign_posn"
.LASF34:
	.string	"_ZNSt11char_traitsIcE11eq_int_typeERKiS2_"
.LASF51:
	.string	"_S_uppercase"
.LASF30:
	.string	"_ZNSt11char_traitsIcE12to_char_typeERKi"
.LASF230:
	.string	"_Atomic_word"
.LASF86:
	.string	"showbase"
.LASF55:
	.string	"_S_ios_fmtflags_end"
.LASF78:
	.string	"Init"
.LASF107:
	.string	"ostream"
.LASF202:
	.string	"decimal_point"
.LASF8:
	.string	"__count"
.LASF181:
	.string	"__gnu_cxx"
.LASF200:
	.string	"bool"
.LASF191:
	.string	"long double"
.LASF122:
	.string	"putwc"
.LASF45:
	.string	"_S_scientific"
.LASF88:
	.string	"showpos"
.LASF54:
	.string	"_S_floatfield"
.LASF43:
	.string	"_S_oct"
.LASF7:
	.string	"__wchb"
.LASF265:
	.string	"__static_initialization_and_destruction_0"
.LASF176:
	.string	"_ZNSt11char_traitsIcE7compareEPKcS2_j"
.LASF195:
	.string	"long long unsigned int"
.LASF177:
	.string	"wcspbrk"
.LASF190:
	.string	"wcstold"
.LASF221:
	.string	"int_p_sep_by_space"
.LASF75:
	.string	"_S_ios_seekdir_end"
.LASF19:
	.string	"length"
.LASF192:
	.string	"wcstoll"
.LASF179:
	.string	"wcsstr"
.LASF65:
	.string	"_Ios_Iostate"
.LASF166:
	.string	"long unsigned int"
.LASF248:
	.string	"_ZN9__gnu_cxx24__numeric_traits_integerIcE5__maxE"
.LASF156:
	.string	"wcsrtombs"
.LASF92:
	.string	"adjustfield"
.LASF147:
	.string	"tm_wday"
.LASF50:
	.string	"_S_unitbuf"
.LASF16:
	.string	"_ZNSt11char_traitsIcE2eqERKcS2_"
.LASF59:
	.string	"_S_ate"
.LASF94:
	.string	"floatfield"
.LASF125:
	.string	"swscanf"
.LASF186:
	.string	"__digits"
.LASF158:
	.string	"wcstod"
.LASF160:
	.string	"wcstof"
.LASF162:
	.string	"wcstok"
.LASF163:
	.string	"wcstol"
.LASF0:
	.string	"__FILE"
.LASF87:
	.string	"showpoint"
.LASF226:
	.string	"setlocale"
.LASF236:
	.string	"wctype"
.LASF178:
	.string	"wcsrchr"
.LASF116:
	.string	"fwscanf"
.LASF5:
	.string	"wint_t"
.LASF103:
	.string	"ios_base"
.LASF97:
	.string	"badbit"
.LASF235:
	.string	"wctrans"
.LASF203:
	.string	"thousands_sep"
.LASF98:
	.string	"eofbit"
.LASF152:
	.string	"wcslen"
.LASF96:
	.string	"iostate"
.LASF31:
	.string	"to_int_type"
.LASF29:
	.string	"to_char_type"
.LASF257:
	.string	"__debug"
.LASF150:
	.string	"tm_gmtoff"
.LASF206:
	.string	"currency_symbol"
.LASF198:
	.string	"short int"
.LASF21:
	.string	"_ZNSt11char_traitsIcE6lengthEPKc"
.LASF139:
	.string	"wcsftime"
.LASF209:
	.string	"mon_grouping"
.LASF73:
	.string	"_S_cur"
.LASF258:
	.string	"_ZNSt11char_traitsIcE6assignERcRKc"
.LASF134:
	.string	"wcscat"
.LASF256:
	.string	"11__mbstate_t"
.LASF224:
	.string	"int_p_sign_posn"
.LASF151:
	.string	"tm_zone"
.LASF132:
	.string	"vwscanf"
.LASF70:
	.string	"_S_ios_iostate_end"
.LASF133:
	.string	"wcrtomb"
.LASF201:
	.string	"lconv"
.LASF90:
	.string	"unitbuf"
.LASF259:
	.string	"_ZNSt11char_traitsIcE3eofEv"
.LASF153:
	.string	"wcsncat"
.LASF263:
	.string	"__numeric_traits_integer<short int>"
.LASF244:
	.string	"__dso_handle"
.LASF193:
	.string	"long long int"
.LASF112:
	.string	"fputwc"
.LASF113:
	.string	"fputws"
.LASF79:
	.string	"~Init"
.LASF121:
	.string	"mbsrtowcs"
.LASF69:
	.string	"_S_failbit"
.LASF214:
	.string	"p_cs_precedes"
.LASF188:
	.string	"__numeric_traits_integer<long unsigned int>"
.LASF146:
	.string	"tm_year"
.LASF13:
	.string	"short unsigned int"
.LASF106:
	.string	"_Traits"
.LASF128:
	.string	"vfwscanf"
.LASF71:
	.string	"_Ios_Seekdir"
.LASF95:
	.string	"fmtflags"
.LASF229:
	.string	"__int32_t"
.LASF117:
	.string	"getwc"
.LASF120:
	.string	"mbsinit"
.LASF233:
	.string	"iswctype"
.LASF27:
	.string	"assign"
.LASF204:
	.string	"grouping"
.LASF173:
	.string	"wprintf"
.LASF260:
	.string	"_ZNSt11char_traitsIcE7not_eofERKi"
.LASF22:
	.string	"_ZNSt11char_traitsIcE4findEPKcjRS1_"
.LASF111:
	.string	"wchar_t"
.LASF165:
	.string	"wcstoul"
	.hidden	__dso_handle
	.ident	"GCC: (Ubuntu 4.8.4-2ubuntu1~14.04) 4.8.4"
	.section	.note.GNU-stack,"",@progbits
